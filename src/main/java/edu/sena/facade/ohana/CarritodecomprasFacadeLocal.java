/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Carritodecompras;
import edu.sena.entity.ohana.ItemCarrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josea
 */
@Local
public interface CarritodecomprasFacadeLocal {

    void create(Carritodecompras carritodecompras);

    void edit(Carritodecompras carritodecompras);

    void remove(Carritodecompras carritodecompras);

    Carritodecompras find(Object id);

    List<Carritodecompras> findAll();

    List<Carritodecompras> findRange(int[] range);

    int count();
    
    public int agregarCarrito(int idCliente, int idProducto);
    
    public List<Integer> getCarrito(int numeroCedula);
    
    public void setCarrito(int numeroCedula);
    
    public int[] getProductoenCarrito(int idCarrito, int idProducto);
    
    public void setProductoenCarrito(int idCarrito, int idProducto);
    
    public void updateProductoenCarrito(int idItem, int qty);
}
