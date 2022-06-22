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
import edu.sena.facade.ohana.VentasFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

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
    
    @EJB
    VentasFacadeLocal ventasFacadeLocal;
    
    private double total;
    private int carritoId = 0;
    private List<ItemCarrito> items;

    public int getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(int carritoId) {
        this.carritoId = carritoId;
    }
    
    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }
    
    /**
     * Creates a new instance of CarritoCompras
     */
    public CarritoCompras() {
    }
    
    public List<ItemCarrito> findByNumeroCedula(int numeroCedula){
        List<Integer> idCarrito = carritodecomprasFacadeLocal.getCarrito(numeroCedula);        
        if (idCarrito.size() == 1) {
            this.setCarritoId(idCarrito.get(0));
            Carritodecompras carrito = carritodecomprasFacadeLocal.find(idCarrito.get(0));
            this.setItems(ItemCarritoFacadeLocal.findByCarritoId(carrito));
            return ItemCarritoFacadeLocal.findByCarritoId(carrito);
        }
        return null;
    }
    
   public double getTotal() {
       int total = 0;
       
       if (this.getCarritoId() != 0) {
           if (this.getItems().size() > 0) {
               for (ItemCarrito items : this.getItems()) {
                   total += items.getProductId().getPrecio() * items.getCantidad();
               }
           }
       }
       return total;
   }
   
   public int getTotalUnidades() {
       int totalUnidades = 0;
       
       if (this.getCarritoId() != 0) {
           if (this.getItems().size() > 0) {
               for (ItemCarrito item : this.getItems()) {
                   totalUnidades += item.getCantidad();
               }
           }
       }
       return totalUnidades;
   }
   
   public void limpiarCarrito() {
        if (this.getCarritoId() != 0) {
            if (this.getItems().size() > 0) {
                for (ItemCarrito item : this.getItems()) {
                    this.remove(item);
                }
            }
        }
   }
    
    public void remove(ItemCarrito itemCarrito){
        ItemCarritoFacadeLocal.remove(itemCarrito);
    }
    
    public void hacerCompra(int numeroCedula) {
        try {
            if (this.getCarritoId() != 0) {
                if (this.getItems().size() > 0) {
                    this.getTotal();
                    ventasFacadeLocal.setVenta(this.getTotalUnidades(), this.getTotal(), numeroCedula);
                    this.limpiarCarrito();
                    PrimeFaces.current().executeScript("Swal.fire("
                            + " 'Orden',"
                            + " 'creada con exito', "
                            + " 'success'"
                            + ")");
                } else {
                    PrimeFaces.current().executeScript("Swal.fire("
                            + " 'Orden',"
                            + " 'Por favor agregar productos al carrito', "
                            + " 'error'"
                            + ")");
                }
            }
            
        } catch(Exception e) {
            System.out.println("hacerCompra ERROR: " + e.getMessage());
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Orden',"
                    + " 'No se pudo crear', "
                    + " 'error'"
                    + ")");
        }
    }
}

