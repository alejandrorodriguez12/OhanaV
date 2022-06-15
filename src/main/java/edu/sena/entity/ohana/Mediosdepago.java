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
@Table(name = "mediosdepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediosdepago.findAll", query = "SELECT m FROM Mediosdepago m"),
    @NamedQuery(name = "Mediosdepago.findByIdMediosDePago", query = "SELECT m FROM Mediosdepago m WHERE m.idMediosDePago = :idMediosDePago"),
    @NamedQuery(name = "Mediosdepago.findByMedioDePago", query = "SELECT m FROM Mediosdepago m WHERE m.medioDePago = :medioDePago")})
public class Mediosdepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMediosDePago")
    private Integer idMediosDePago;
    @Size(max = 11)
    @Column(name = "medioDePago")
    private String medioDePago;
    @OneToMany(mappedBy = "idMediosDePago")
    private Collection<Ventas> ventasCollection;

    public Mediosdepago() {
    }

    public Mediosdepago(Integer idMediosDePago) {
        this.idMediosDePago = idMediosDePago;
    }

    public Integer getIdMediosDePago() {
        return idMediosDePago;
    }

    public void setIdMediosDePago(Integer idMediosDePago) {
        this.idMediosDePago = idMediosDePago;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
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
        hash += (idMediosDePago != null ? idMediosDePago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediosdepago)) {
            return false;
        }
        Mediosdepago other = (Mediosdepago) object;
        if ((this.idMediosDePago == null && other.idMediosDePago != null) || (this.idMediosDePago != null && !this.idMediosDePago.equals(other.idMediosDePago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Mediosdepago[ idMediosDePago=" + idMediosDePago + " ]";
    }
    
}
