/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;


import edu.sena.entity.ohana.Estadodeenvios;
import edu.sena.entity.ohana.Ventas;
import edu.sena.facade.ohana.EstadodeenviosFacadeLocal;
import edu.sena.entity.ohana.Personas;
import edu.sena.facade.ohana.VentasFacadeLocal;
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
@Named(value = "ventasSession")
@SessionScoped
public class ventasSession implements Serializable {
@EJB
VentasFacadeLocal ventasFacadeLocal;
@EJB
EstadodeenviosFacadeLocal estadodeenviosFacadeLocal;

private int idEstadoEnvio;

private ArrayList<Estadodeenvios> ListaEstadoEnvio = new ArrayList<>();
    
    public ventasSession() {
    }
    
    @PostConstruct
    public void init(){
        ListaEstadoEnvio.addAll(estadodeenviosFacadeLocal.findAll());
    }
    
    public List<Ventas> leerTodo(){
        return ventasFacadeLocal.leerTodo();
    }
    
    public List<Ventas> getByPersona(Personas persona){
        return ventasFacadeLocal.getByPersona(persona);
    }
    
    public void cambiarEstados(Ventas venta, int idEstado){
        try {
            if(venta != null){
                venta.setIdEstadoDeEnvios(
                    estadodeenviosFacadeLocal.find(idEstado)
                );
                ventasFacadeLocal.edit(venta);
            }
            PrimeFaces.current().executeScript("Swal.fire("
                    + "'Usuario',"
                    + "'Actualizado con exito !!!'"
                    + "'Error'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "'Usuario',"
                    + "'No se pudo actualizar, intente de nuevo'"
                    + "'Error'"
                    + ")");
        }
    }

    public int getIdEstadoEnvio() {
        return idEstadoEnvio;
    }

    public void setIdEstadoEnvio(int idEstadoEnvio) {
        this.idEstadoEnvio = idEstadoEnvio;
    }

    public ArrayList<Estadodeenvios> getListaEstadoEnvio() {
        return ListaEstadoEnvio;
    }

    public void setListaEstadoEnvio(ArrayList<Estadodeenvios> ListaEstadoEnvio) {
        this.ListaEstadoEnvio = ListaEstadoEnvio;
    }
}
