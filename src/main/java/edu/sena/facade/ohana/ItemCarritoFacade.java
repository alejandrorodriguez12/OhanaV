/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.ItemCarrito;
import edu.sena.entity.ohana.Carritodecompras;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josea
 */
@Stateless
public class ItemCarritoFacade extends AbstractFacade<ItemCarrito> implements ItemCarritoFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemCarritoFacade() {
        super(ItemCarrito.class);
    }
    
    @Override
    public List<ItemCarrito> findByCarritoId(Carritodecompras carrito) {           
        Query p = em.createQuery("SELECT u FROM ItemCarrito u WHERE u.idCarrito = :idIn");
        p.setParameter("idIn", carrito);
        return p.getResultList();
    }
    
    @Override
    public void removeItem(int idItem) {
        try {
            this.remove(this.find(idItem));
        } catch (Exception e) {
            System.out.println("erro!!: " + e.getMessage());
        }
        
    }
    
}
