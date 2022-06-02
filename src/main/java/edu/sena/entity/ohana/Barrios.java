/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.ohana;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "barrios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrios.findAll", query = "SELECT b FROM Barrios b"),
    @NamedQuery(name = "Barrios.findByIdBarrio", query = "SELECT b FROM Barrios b WHERE b.idBarrio = :idBarrio"),
    @NamedQuery(name = "Barrios.findByNombreBarrio", query = "SELECT b FROM Barrios b WHERE b.nombreBarrio = :nombreBarrio")})
public class Barrios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Size(max = 20)
    @Column(name = "nombreBarrio")
    private String nombreBarrio;
    @JoinColumn(name = "numeroLocalidad", referencedColumnName = "numeroLocalidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localidades numeroLocalidad;

    public Barrios() {
    }

    public Barrios(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public Localidades getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Localidades numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarrio != null ? idBarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrios)) {
            return false;
        }
        Barrios other = (Barrios) object;
        if ((this.idBarrio == null && other.idBarrio != null) || (this.idBarrio != null && !this.idBarrio.equals(other.idBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Barrios[ idBarrio=" + idBarrio + " ]";
    }
    
}
