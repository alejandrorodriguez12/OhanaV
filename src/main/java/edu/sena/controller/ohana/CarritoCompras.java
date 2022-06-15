/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Carritodecompras;
import edu.sena.entity.ohana.ItemCarrito;
import edu.sena.facade.ohana.CarritodecomprasFacadeLocal;
import edu.sena.facade.ohana.ItemCarritoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author josea
 */
@Named(value = "carritoCompras")
@SessionScoped
public class CarritoCompras implements Serializable {

    @EJB
    ItemCarritoFacadeLocal ItemCarritoFacadeLocal;
    
    @EJB
    CarritodecomprasFacadeLocal carritodecomprasFacadeLocal; 
    
    /**
     * Creates a new instance of CarritoCompras
     */
    public CarritoCompras() {
    }
    
    public List<ItemCarrito> findByNumeroCedula(int numeroCedula){
        List<Integer> idCarrito = carritodecomprasFacadeLocal.getCarrito(numeroCedula);
        if (idCarrito.size() == 1) {
            Carritodecompras carrito = carritodecomprasFacadeLocal.find(idCarrito.get(0));
            return ItemCarritoFacadeLocal.findByCarritoId(carrito);
        }
        return null;
    }
    
    public void remove(ItemCarrito itemCarrito){
        ItemCarritoFacadeLocal.remove(itemCarrito);
    }
}

