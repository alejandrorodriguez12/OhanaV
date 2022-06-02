/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Inventario;
import edu.sena.entity.ohana.Proveedores;
import edu.sena.entity.ohana.Tipoproductos;
import edu.sena.facade.ohana.InventarioFacadeLocal;
import edu.sena.facade.ohana.ProductosFacadeLocal;
import edu.sena.facade.ohana.ProveedoresFacadeLocal;
import edu.sena.facade.ohana.TipoproductosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 57301
 */
@Named(value = "inventarioSession")
@SessionScoped
public class InventarioSession implements Serializable {
@EJB
InventarioFacadeLocal inventarioFacadeLocal;
@EJB
TipoproductosFacadeLocal tipoproductosFacadeLocal;
@EJB
ProveedoresFacadeLocal proveedoresFacadeLocal;
private int idProducto;
private int idNit;
        
private Inventario stockTem = new Inventario();
private Inventario stockAgr = new Inventario();

    private ArrayList<Tipoproductos> ListaProductos = new ArrayList<>();
    private ArrayList<Proveedores> ListaProveedores = new ArrayList<>();   
    
    public InventarioSession() {
    }
    
    @PostConstruct
    public void init(){
        ListaProductos.addAll(tipoproductosFacadeLocal.findAll());
        ListaProveedores.addAll(proveedoresFacadeLocal.findAll());
    }
    
    public List<Inventario> leerTodo(){
        return inventarioFacadeLocal.findAll();
    }
    
        public void agregarStock() {
        if (inventarioFacadeLocal.agregarStock(stockAgr,idProducto,idNit)) {
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
        stockAgr = new Inventario();
        idProducto = 0;
        idNit = 0;

    }
    
    public String cargarStock(Inventario invIn){
        stockTem = invIn;
        return "inventario_stock-editar";
    }
    
    public void editarStock(){
        try {
            inventarioFacadeLocal.edit(stockTem);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Editado con exito', "
                    + " 'success'"
                    + ")");;
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo editar', "
                    + " 'error'"
                    + ")");
        }
    }
    
    public void removerStock(Inventario invIn){
        try {
            inventarioFacadeLocal.remove(invIn);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Eliminado con exito', "
                    + " 'success'"
                    + ")");;
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo eliminar', "
                    + " 'error'"
                    + ")");
        }
    }

    public Inventario getStockTem() {
        return stockTem;
    }

    public void setStockTem(Inventario stockTem) {
        this.stockTem = stockTem;
    }

    public Inventario getStockAgr() {
        return stockAgr;
    }

    public void setStockAgr(Inventario stockAgr) {
        this.stockAgr = stockAgr;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdNit() {
        return idNit;
    }

    public void setIdNit(int idNit) {
        this.idNit = idNit;
    }

    public ArrayList<Tipoproductos> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(ArrayList<Tipoproductos> ListaProductos) {
        this.ListaProductos = ListaProductos;
    }

    public ArrayList<Proveedores> getListaProveedores() {
        return ListaProveedores;
    }

    public void setListaProveedores(ArrayList<Proveedores> ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }




    
}
