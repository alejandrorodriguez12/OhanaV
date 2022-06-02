/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Inventario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }
    
    @Override
    public boolean agregarStock(Inventario invAgr, int idProducto, int idNit){
        try {
            Query sto = em.createNativeQuery("INSERT INTO inventario (idProducto,nit,precioUnitario,precioVenta,cantidadStock,fechaIngreso,lote) VALUES (?,?,?,?,?,?,?);");
          
            sto.setParameter(1, idProducto);
            sto.setParameter(2, idNit);
            sto.setParameter(3, invAgr.getPrecioUnitario());
            sto.setParameter(4, invAgr.getPrecioVenta());
            sto.setParameter(5, invAgr.getCantidadEntrante());
            sto.setParameter(6, invAgr.getFechaIngreso());
            sto.setParameter(7, invAgr.getLote());
            sto.executeUpdate();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
}
