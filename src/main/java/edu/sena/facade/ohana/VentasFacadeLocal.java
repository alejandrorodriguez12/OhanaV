/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.ItemCarrito;
import edu.sena.entity.ohana.Ventas;
import edu.sena.entity.ohana.Personas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface VentasFacadeLocal {

    void create(Ventas ventas);

    void edit(Ventas ventas);

    void remove(Ventas ventas);

    Ventas find(Object id);

    List<Ventas> findAll();

    List<Ventas> findRange(int[] range);

    int count();
    
    public List<Ventas> leerTodo();
    
    public List<Ventas> getByPersona(Personas persona);
    
    public void setVenta(int unidades, double total, int numeroCedula, List<ItemCarrito> items);
}
