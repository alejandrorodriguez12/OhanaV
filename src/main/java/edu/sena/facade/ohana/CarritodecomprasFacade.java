/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Carritodecompras;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josea
 */
@Stateless
public class CarritodecomprasFacade extends AbstractFacade<Carritodecompras> implements CarritodecomprasFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarritodecomprasFacade() {
        super(Carritodecompras.class);
    }
    
    @Override
    public int agregarCarrito(int numeroCedula, int idProducto) {
        int idCarrito = 0;
        
        System.out.println("Producto: " + idProducto);
        System.out.println("Cedula: " + numeroCedula);
        
        try {
            List<Integer> carrito = this.getCarrito(numeroCedula);
            if (carrito.size() == 1) {
                idCarrito = carrito.get(0);
                System.out.println("¡debug!: Carrito existente");
            } else if (carrito.isEmpty()) {
                try {
                    this.setCarrito(numeroCedula);
                    
                    List<Integer> carritoCreado = this.getCarrito(numeroCedula);
                    if (carritoCreado.size() == 1) {
                        idCarrito = carritoCreado.get(0);
                    }
                    
                    System.out.println("¡debug!: Carrito creado");
                } catch (Exception e) {
                    System.out.println("¡error!: " + e.getMessage());
                }
            }
            
            System.out.println("IdCarrito: " + idCarrito);
            System.out.println("¡debug!: Step 2");
            int idProductoCarrito = 0;
            int[]  productoenCarrito = this.getProductoenCarrito(idCarrito, idProducto);
            System.out.println("Length" + productoenCarrito.length);
            
            if (productoenCarrito.length == 2) {
                this.updateProductoenCarrito(productoenCarrito[0], productoenCarrito[1] + 1);
                System.out.println("¡debug!: Producto existente existente");
                return idCarrito;
            } else if (productoenCarrito.length == 0) {
                try {
                    System.out.println("¡debug!: Step 3.1");
                    this.setProductoenCarrito(idCarrito, idProducto);
                    
                    System.out.println("¡debug!: Step 3.2");
                    int[] productoenCarritoCreado = this.getProductoenCarrito(idCarrito, idProducto);
                    
                    System.out.println("¡debug!: Producto Creado");
                    return idCarrito;
                } catch (Exception e) {
                    System.out.println("¡error!: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("¡error!: " + e.getMessage());
        }
        return 0;
    }
    
    @Override
    public List<Integer> getCarrito(int numeroCedula) {
        List<Integer> carrito = new ArrayList<Integer>();
        
        try {
            Query carritoExistente = em.createNativeQuery("SELECT a.idcarrito FROM carritodecompras a WHERE  a.numeroCedula = ?");
            carritoExistente.setParameter(1,numeroCedula);
            carrito = carritoExistente.getResultList();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
        return carrito;
    }
    
    @Override
    public void setCarrito(int numeroCedula) {        
        try {
            Query carrito = em.createNativeQuery(
                "INSERT INTO carritodecompras (numeroCedula) VALUES (?);"
            );
            carrito.setParameter(1,numeroCedula);
            carrito.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    
    @Override
    public int[] getProductoenCarrito(int idCarrito, int idProducto) {
        int[] result = {0, 0};
        
        try {
            Query q = em.createNativeQuery(
                "SELECT a.itemId, a.cantidad FROM item_carrito a WHERE a.id_Carrito = ? AND a.product_id = ?"
            );
            q.setParameter(1,idCarrito);
            q.setParameter(2,idProducto);
            
            List<Object[]> productoExistente = q.getResultList();
            
            if (!productoExistente.isEmpty()) {
                result[0] = Integer.parseInt(productoExistente.get(0)[0].toString());
                result[1] = Integer.parseInt(productoExistente.get(0)[1].toString());
            } else {
                result = new int[0];
            }
        } catch (NumberFormatException e) {
            System.out.println("error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
        return result;
    }
    
    @Override
    public void setProductoenCarrito(int idCarrito, int idProducto) {
       try {
            Query carrito = em.createNativeQuery(
                "INSERT INTO item_carrito (id_Carrito,product_id,cantidad) VALUES (?,?,?);"
            );
            carrito.setParameter(1, idCarrito);
            carrito.setParameter(2, idProducto);
            carrito.setParameter(3, 1);
            carrito.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    
    @Override
    public void updateProductoenCarrito(int idItem, int qty) {
       try {
            Query carrito = em.createNativeQuery(
                "UPDATE item_carrito SET cantidad = ? WHERE itemId = ?"
            );
            carrito.setParameter(1, qty);
            carrito.setParameter(2, idItem);
            carrito.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}