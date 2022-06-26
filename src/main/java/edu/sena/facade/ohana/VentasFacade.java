/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.ItemCarrito;
import edu.sena.entity.ohana.Ventas;
import edu.sena.entity.ohana.Personas;
import edu.sena.entity.ohana.Productos;
import edu.sena.facade.ohana.ProductosFacadeLocal;
import java.util.List;
import java.time.LocalDate;  
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> implements VentasFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;
    
    @EJB
    ProductosFacadeLocal productosFacadeLocal;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }

    @Override
    public List<Ventas> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query ven = em.createQuery("SELECT u FROM Ventas u");
        return ven.getResultList();
    }
    
    @Override
    public List<Ventas> getByPersona(Personas persona) {
        Query q = em.createQuery("SELECT u FROM Ventas u WHERE u.personas = :idCliente");
        q.setParameter("idCliente", persona);
        return q.getResultList();
    }

    @Override
    public void setVenta(
        int unidades, double total, int numeroCedula, List<ItemCarrito> items
    ) {
        try {
            Query venta = em.createNativeQuery(
                "INSERT INTO ventas (" + 
                "cantidadProducto,valorTotal,fechaVenta,idCliente,idEstadoDeEnvios,idMediosDePago,idAdministrador,idTipoProducto" + 
                ") VALUES (?,?,?,?,1,1,1,1);"
            );
            venta.setParameter(1, unidades);
            venta.setParameter(2, (int)total);
            venta.setParameter(3, LocalDate.now());
            venta.setParameter(4, numeroCedula);
            venta.executeUpdate();
            
            productosFacadeLocal.actualizarStock(items);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}