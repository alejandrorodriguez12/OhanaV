/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;


import com.csvreader.CsvReader;
import edu.sena.entity.ohana.Proveedores;
import edu.sena.facade.ohana.ProveedoresFacadeLocal;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.file.UploadedFile;

@Named
@ViewScoped
public class CsvJava implements Serializable{
    
    @EJB
    private ProveedoresFacadeLocal EJBproveedores;
    private Proveedores proveedores;
    private List<Proveedores> listaProveedores;
    
    private UploadedFile file;

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public List<Proveedores> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    @PostConstruct
    public void construct(){
        Proveedores proveedores = new Proveedores();
    }
    
    public void insertar(){
        try {
            if(file.getSize() > 0){
                CsvReader leerArchivos;
                leerArchivos = new CsvReader(new InputStreamReader(file.getInputStream()));
                leerArchivos.readHeaders();
                while(leerArchivos.readRecord()){
                    proveedores = new Proveedores();
                    proveedores.setNit(Integer.parseInt(leerArchivos.get(0)));
                    proveedores.setNombreEmpresa(leerArchivos.get(1));
                    proveedores.setProducto(leerArchivos.get(2));
                    proveedores.setNumeroCedula(Integer.parseInt(leerArchivos.get(3)));
                    proveedores.setNombreProveedor(leerArchivos.get(4));
                    proveedores.setApellidoProveedor(leerArchivos.get(5));
                    EJBproveedores.create(proveedores);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}