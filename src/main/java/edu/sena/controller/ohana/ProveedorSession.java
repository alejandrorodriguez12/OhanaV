package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Proveedores;
import edu.sena.facade.ohana.ProveedoresFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 57301
 */
@Named(value = "proveedorSession")
@SessionScoped
public class ProveedorSession implements Serializable {

    @EJB
    ProveedoresFacadeLocal proveedoresFacadeLocal;

    private Proveedores provagr = new Proveedores();
    private Proveedores ProvTem = new Proveedores();

    public ProveedorSession() {
    }

    public List<Proveedores> leerTodo() {
        return proveedoresFacadeLocal.leerTodo();
    }

    public void agregarProveedor() {
        if (proveedoresFacadeLocal.agregarProveedor(provagr)) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Proveedor',"
                    + " 'Agregado con exito', "
                    + " 'success'"
                    + ")");
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Proveedor',"
                    + " 'No se pudo agregar', "
                    + " 'error'"
                    + ")");
        }
        provagr = new Proveedores();
    }

    public String cargaProveedor(Proveedores provIn) {
        ProvTem = provIn;
        return "inventario_proveedores-editar";
    }

    public void editarProveedor() {
        try {
            proveedoresFacadeLocal.edit(ProvTem);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Proveedor',"
                    + " 'Actualizado con exito', "
                    + " 'success'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Proveedor',"
                    + " 'No se pudo actualizar', "
                    + " 'error'"
                    + ")");
        }

    }

    public void removerProveedor(Proveedores provIn) {
        try {
            proveedoresFacadeLocal.remove(provIn);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Proveedor',"
                    + " 'Removido con exito', "
                    + " 'success'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Proveedor',"
                    + " 'No se pudo Remover', "
                    + " 'error'"
                    + ")");
        }
    }

    public Proveedores getProvagr() {
        return provagr;
    }

    public void setProvagr(Proveedores provagr) {
        this.provagr = provagr;
    }

    public Proveedores getProvTem() {
        return ProvTem;
    }

    public void setProvTem(Proveedores ProvTem) {
        this.ProvTem = ProvTem;
    }

}
