/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Proveedores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> implements ProveedoresFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }

    @Override
    public List<Proveedores> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query prov = em.createQuery("SELECT p FROM Proveedores p");
        return prov.getResultList();
    }

    @Override
    public boolean agregarProveedor(Proveedores provagr) {
        try {
            Query prov = em.createNativeQuery("INSERT INTO proveedores (nit, nombreEmpresa, producto, numeroCedula, nombreProveedor) VALUES (?,?,?,?,?);");
            prov.setParameter(1, provagr.getNit());
            prov.setParameter(2, provagr.getNombreEmpresa());
            prov.setParameter(3, provagr.getProducto());
            prov.setParameter(4, provagr.getNumeroCedula());
            prov.setParameter(5, provagr.getNombreProveedor());
            prov.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
