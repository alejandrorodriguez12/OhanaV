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
@Table(name = "localidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l"),
    @NamedQuery(name = "Localidades.findByNumeroLocalidad", query = "SELECT l FROM Localidades l WHERE l.numeroLocalidad = :numeroLocalidad"),
    @NamedQuery(name = "Localidades.findByNombreLocalidad", query = "SELECT l FROM Localidades l WHERE l.nombreLocalidad = :nombreLocalidad")})
public class Localidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroLocalidad")
    private Integer numeroLocalidad;
    @Size(max = 18)
    @Column(name = "nombreLocalidad")
    private String nombreLocalidad;
    @OneToMany(mappedBy = "numeroLocalidad")
    private Collection<Barrios> barriosCollection;
    @OneToMany(mappedBy = "numeroLocalidad")
    private Collection<Personas> personasCollection;

    public Localidades() {
    }

    public Localidades(Integer numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public Integer getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Integer numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    @XmlTransient
    public Collection<Barrios> getBarriosCollection() {
        return barriosCollection;
    }

    public void setBarriosCollection(Collection<Barrios> barriosCollection) {
        this.barriosCollection = barriosCollection;
    }

    @XmlTransient
    public Collection<Personas> getPersonasCollection() {
        return personasCollection;
    }

    public void setPersonasCollection(Collection<Personas> personasCollection) {
        this.personasCollection = personasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLocalidad != null ? numeroLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.numeroLocalidad == null && other.numeroLocalidad != null) || (this.numeroLocalidad != null && !this.numeroLocalidad.equals(other.numeroLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Localidades[ numeroLocalidad=" + numeroLocalidad + " ]";
    }
    
}
