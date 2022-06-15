/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.ohana;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByNit", query = "SELECT p FROM Proveedores p WHERE p.nit = :nit"),
    @NamedQuery(name = "Proveedores.findByNombreEmpresa", query = "SELECT p FROM Proveedores p WHERE p.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Proveedores.findByProducto", query = "SELECT p FROM Proveedores p WHERE p.producto = :producto"),
    @NamedQuery(name = "Proveedores.findByNumeroCedula", query = "SELECT p FROM Proveedores p WHERE p.numeroCedula = :numeroCedula"),
    @NamedQuery(name = "Proveedores.findByNombreProveedor", query = "SELECT p FROM Proveedores p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedores.findByApellidoProveedor", query = "SELECT p FROM Proveedores p WHERE p.apellidoProveedor = :apellidoProveedor")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private Integer nit;
    @Size(max = 20)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Size(max = 10)
    @Column(name = "producto")
    private String producto;
    @Column(name = "numeroCedula")
    private Integer numeroCedula;
    @Size(max = 20)
    @Column(name = "nombreProveedor")
    private String nombreProveedor;
    @Size(max = 20)
    @Column(name = "apellidoProveedor")
    private String apellidoProveedor;
    @OneToMany(mappedBy = "nit")
    private Collection<Inventario> inventarioCollection;

    public Proveedores() {
    }

    public Proveedores(Integer nit) {
        this.nit = nit;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Integer numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getApellidoProveedor() {
        return apellidoProveedor;
    }

    public void setApellidoProveedor(String apellidoProveedor) {
        this.apellidoProveedor = apellidoProveedor;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Proveedores[ nit=" + nit + " ]";
    }
    
}
