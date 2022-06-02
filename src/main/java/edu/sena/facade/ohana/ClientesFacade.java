/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Clientes;
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
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    @Override
    public List<Clientes> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query cli = em.createQuery("SELECT c FROM Clientes c");
        return cli.getResultList();
    }
    
    @Override
        public Clientes inicioSesion(String correoIn, String contraseniaIn) {
        try {
            Query p = em.createQuery("SELECT p FROM personas p WHERE p.correo = :correoIn AND p.contrasenia = :contraseniaIn;");
            p.setParameter("correoIn", correoIn);
            p.setParameter("contraseniaIn", contraseniaIn);
            return (Clientes) p.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }


}