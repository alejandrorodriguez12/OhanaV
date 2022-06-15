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
@Table(name = "estadodeenvios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadodeenvios.findAll", query = "SELECT e FROM Estadodeenvios e"),
    @NamedQuery(name = "Estadodeenvios.findByIdEstadoDeEnvios", query = "SELECT e FROM Estadodeenvios e WHERE e.idEstadoDeEnvios = :idEstadoDeEnvios"),
    @NamedQuery(name = "Estadodeenvios.findByEstadoDeEnvio", query = "SELECT e FROM Estadodeenvios e WHERE e.estadoDeEnvio = :estadoDeEnvio")})
public class Estadodeenvios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadoDeEnvios")
    private Integer idEstadoDeEnvios;
    @Size(max = 10)
    @Column(name = "estadoDeEnvio")
    private String estadoDeEnvio;
    @OneToMany(mappedBy = "idEstadoDeEnvios")
    private Collection<Ventas> ventasCollection;

    public Estadodeenvios() {
    }

    public Estadodeenvios(Integer idEstadoDeEnvios) {
        this.idEstadoDeEnvios = idEstadoDeEnvios;
    }

    public Integer getIdEstadoDeEnvios() {
        return idEstadoDeEnvios;
    }

    public void setIdEstadoDeEnvios(Integer idEstadoDeEnvios) {
        this.idEstadoDeEnvios = idEstadoDeEnvios;
    }

    public String getEstadoDeEnvio() {
        return estadoDeEnvio;
    }

    public void setEstadoDeEnvio(String estadoDeEnvio) {
        this.estadoDeEnvio = estadoDeEnvio;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoDeEnvios != null ? idEstadoDeEnvios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadodeenvios)) {
            return false;
        }
        Estadodeenvios other = (Estadodeenvios) object;
        if ((this.idEstadoDeEnvios == null && other.idEstadoDeEnvios != null) || (this.idEstadoDeEnvios != null && !this.idEstadoDeEnvios.equals(other.idEstadoDeEnvios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Estadodeenvios[ idEstadoDeEnvios=" + idEstadoDeEnvios + " ]";
    }
    
}
