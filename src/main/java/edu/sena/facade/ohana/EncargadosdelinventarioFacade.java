/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Encargadosdelinventario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 57301
 */
@Stateless
public class EncargadosdelinventarioFacade extends AbstractFacade<Encargadosdelinventario> implements EncargadosdelinventarioFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncargadosdelinventarioFacade() {
        super(Encargadosdelinventario.class);
    }
    
}
