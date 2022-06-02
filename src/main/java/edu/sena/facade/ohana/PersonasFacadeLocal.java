/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Personas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface PersonasFacadeLocal {

    void create(Personas personas);

    void edit(Personas personas);

    void remove(Personas personas);

    Personas find(Object id);

    List<Personas> findAll();

    List<Personas> findRange(int[] range);

    int count();
    
    public boolean crearCliente(Personas perCre);
    
    public Personas inicioSesion(String correoIn, String contraseniaIn);
    
    public Personas recuperarContraseña(String correoIn);
    
    public boolean agregarCliente(Personas perCre);
    
    
}
