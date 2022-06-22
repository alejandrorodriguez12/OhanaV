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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "tipoproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproductos.findAll", query = "SELECT t FROM Tipoproductos t"),
    @NamedQuery(name = "Tipoproductos.findByIdTipoProducto", query = "SELECT t FROM Tipoproductos t WHERE t.idTipoProducto = :idTipoProducto"),
    @NamedQuery(name = "Tipoproductos.findByNombreProducto", query = "SELECT t FROM Tipoproductos t WHERE t.nombreProducto = :nombreProducto")})
public class Tipoproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoProducto")
    private Integer idTipoProducto;
    @Size(max = 15)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @OneToMany(mappedBy = "idTipoProducto", fetch = FetchType.LAZY)
    private Collection<Ventas> ventasCollection;
    @OneToMany(mappedBy = "idTipoProducto", fetch = FetchType.LAZY)
    private Collection<Productos> productosCollection;

    public Tipoproductos() {
    }

    public Tipoproductos(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProducto != null ? idTipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproductos)) {
            return false;
        }
        Tipoproductos other = (Tipoproductos) object;
        if ((this.idTipoProducto == null && other.idTipoProducto != null) || (this.idTipoProducto != null && !this.idTipoProducto.equals(other.idTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Tipoproductos[ idTipoProducto=" + idTipoProducto + " ]";
    }
    
}
