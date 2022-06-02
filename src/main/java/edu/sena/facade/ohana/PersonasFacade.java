/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Personas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
        @Override
    public boolean crearCliente(Personas perCre) {
        try {
            Query cli = em.createNativeQuery("INSERT INTO personas (numeroCedula,primerNombre,segundoNombre,primerApellido,segundoApellido,correo,numeroCelular,fechaDeNacimiento,contrasenia) VALUES (?,?,?,?,?,?,?,?,?);");
            cli.setParameter(1, perCre.getNumeroCedula());
            cli.setParameter(2, perCre.getPrimerNombre());
            cli.setParameter(3, perCre.getSegundoNombre());
            cli.setParameter(4, perCre.getPrimerApellido());
            cli.setParameter(5, perCre.getSegundoApellido());
            cli.setParameter(6, perCre.getCorreo());
            cli.setParameter(7, perCre.getNumeroCelular());
            cli.setParameter(8, perCre.getFechaDeNacimiento());
            cli.setParameter(9, perCre.getContrasenia());
            cli.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    @Override
        public boolean agregarCliente(Personas perCre) {
        try {
            Query cli = em.createNativeQuery("INSERT INTO Clientes (numeroCedula,estados) VALUES (?,?);");
            cli.setParameter(1, perCre.getNumeroCedula());
            cli.setParameter(2, 1);
            cli.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
  

    @Override
    public Personas inicioSesion(String correoIn, String contraseniaIn) {
        try {
            Query p = em.createQuery("SELECT p FROM Personas p WHERE p.correo = :correoIn AND p.contrasenia = :contraseniaIn");
            p.setParameter("correoIn", correoIn);
            p.setParameter("contraseniaIn", contraseniaIn);
            return (Personas) p.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
 
    @Override
    public Personas recuperarContraseña(String correoIn) {
        try {
            Query p = em.createQuery("select p from personas p, roles_personas p where personas.correo = :correoIn;");
            p.setParameter("correoIn", correoIn);
            return (Personas) p.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    } 
    
}
