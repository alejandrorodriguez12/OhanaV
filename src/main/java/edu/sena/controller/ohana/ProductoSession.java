/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Productos;
import edu.sena.entity.ohana.Tipoproductos;
import edu.sena.facade.ohana.ProductosFacadeLocal;
import edu.sena.facade.ohana.TipoproductosFacadeLocal;
import edu.sena.facade.ohana.CarritodecomprasFacadeLocal;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 57301
 */
@Named(value = "productoSession")
@SessionScoped
public class ProductoSession implements Serializable {

   @EJB
    ProductosFacadeLocal productosFacadeLocal;
   @EJB
    TipoproductosFacadeLocal tipoproductosFacadeLocal;
   @EJB
    CarritodecomprasFacadeLocal carritodecomprasFacadeLocal;
   
   private int idProducto;
   private int idTipoProducto;
      PreparedStatement ps;
    ResultSet rs;
    int r=0;
           
    private Productos prodagr = new Productos();
    private Productos protem = new Productos();
    
    private ArrayList<Tipoproductos> listaProducto = new ArrayList<>();
    private ArrayList<Productos> listaproductos = new ArrayList<>();
    
    public ProductoSession() {
    }
    
    @PostConstruct
    public void init(){
        listaProducto.addAll(tipoproductosFacadeLocal.findAll());
        listaproductos.addAll(productosFacadeLocal.findAll());
    }
    
     public List<Productos> leerTodo() {
        return productosFacadeLocal.leerTodo();
    }
     

    public void agregarProducto() {
        if (productosFacadeLocal.agregarProducto(prodagr,idProducto,idTipoProducto)) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Agregado con exito', "
                    + " 'success'"
                    + ")");;
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo agregar', "
                    + " 'error'"
                    + ")");
        }
    prodagr = new Productos();
    idProducto = 0;
    idTipoProducto = 0;
    }

    public String cargaProducto(Productos proIn) {
        protem = proIn;
        return "inventario_editarproductos";
    }

    public void editarProducto() {
        try {
            productosFacadeLocal.edit(protem);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Actualizado con exito', "
                    + " 'success'"
                    + ")");
         
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo actualizar', "
                    + " 'error'"
                    + ")");
        }
    }

    public void removerproducto(Productos proIn) {
        try {
            productosFacadeLocal.remove(proIn);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Removido con exito', "
                    + " 'success'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo eliminar', "
                    + " 'error'"
                    + ")");
        }
    }
    
    public List<Productos> findNombresStartWith(String nombres){
         return productosFacadeLocal.findNombresStartWith(nombres);
     }
    
    public List<Productos> findByCamisetasHStartsWith(String nombres){
         return productosFacadeLocal.findByCamisetasHStartsWith(nombres);
     }
    
    public List<Productos> findByCamisetasMStartsWith(String nombres){
         return productosFacadeLocal.findByCamisetasMStartsWith(nombres);
     }
    
    public List<Productos> findByGorrasStartsWith(String nombres){
         return productosFacadeLocal.findByGorrasStartsWith(nombres);
     }

    public Productos getProdagr() {
        return prodagr;
    }

    public void setProdagr(Productos prodagr) {
        this.prodagr = prodagr;
    }

    public Productos getProtem() {
        return protem;
    }

    public void setProtem(Productos protem) {
        this.protem = protem;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ArrayList<Tipoproductos> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Tipoproductos> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public ArrayList<Productos> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(ArrayList<Productos> listaproductos) {
        this.listaproductos = listaproductos;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public void addItemCart(int idProducto, int numeroCedula) {             
        if (carritodecomprasFacadeLocal.agregarCarrito(numeroCedula, idProducto) > 0) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Agregado con exito', "
                    + " 'success'"
                    + ")");
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo agregar', "
                    + " 'error'"
                    + ")");
        }
    }
}
