/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Clientes;
import edu.sena.facade.ohana.ClientesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 57301
 */
@Named(value = "clienteSession")
@SessionScoped
public class ClienteSession implements Serializable {

    @EJB
    ClientesFacadeLocal clientesFacadeLocal;

    private Clientes crecli = new Clientes();
    private Clientes logcli = new Clientes();
    private String correoIn = "";
    private String contraseniaIn = "";

    /**
     * Creates a new instance of ClienteSession
     */
    public ClienteSession() {
    }

    public List<Clientes> leerTodo() {
        return clientesFacadeLocal.leerTodo();
    }
    
    public void actualizarDatos(){
        try {
            clientesFacadeLocal.edit(logcli);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Usuario',"
                    + " 'Actualizado con exito', "
                    + " 'success'"
                    + ")");
            
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Usuario',"
                    + " 'No se pudo Actualizar', "
                    + " 'error'"
                    + ")");
        }
    }
    
        public void validarUsuario(){
        try {
            logcli = clientesFacadeLocal.inicioSesion(correoIn, contraseniaIn);
            if(logcli != null){
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("ingreso.xhtml");
            }else{
                PrimeFaces.current().executeScript("Swal.fire("
                                          + " 'Usuario',"
                                          + " 'No existe en la base de datos', "
                                          + " 'error'"
                                          +  ")");
            }
        } catch (Exception e) {
        }
    }

    public void cambiarEstado(Clientes cliE){
        try {
            if(cliE.getEstados().toString().equals("1")){
                cliE.setEstados(Short.parseShort("0"));
            }else{
                cliE.setEstados(Short.parseShort("1"));
            }
            clientesFacadeLocal.edit(cliE);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Estado cliente',"
                    + " 'Actualizado con exito', "
                    + " 'success'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "'Usuario',"
                    + "'No se pudo actualizar, intente de nuevo'"
                    + "'Error'"
                    + ")");
        }
    }    
  
    

    public Clientes getCrecli() {
        return crecli;
    }

    public void setCrecli(Clientes crecli) {
        this.crecli = crecli;
    }

    public Clientes getLogcli() {
        return logcli;
    }

    public void setLogcli(Clientes logcli) {
        this.logcli = logcli;
    }

    public String getCorreoIn() {
        return correoIn;
    }

    public void setCorreoIn(String correoIn) {
        this.correoIn = correoIn;
    }

    public String getContraseniaIn() {
        return contraseniaIn;
    }

    public void setContraseniaIn(String contraseniaIn) {
        this.contraseniaIn = contraseniaIn;
    }

}

