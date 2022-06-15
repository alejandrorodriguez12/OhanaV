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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "recibos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibos.findAll", query = "SELECT r FROM Recibos r"),
    @NamedQuery(name = "Recibos.findByIdRecibos", query = "SELECT r FROM Recibos r WHERE r.idRecibos = :idRecibos")})
public class Recibos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRecibos")
    private Integer idRecibos;
    @JoinColumn(name = "idVentas", referencedColumnName = "idVentas")
    @ManyToOne
    private Ventas idVentas;

    public Recibos() {
    }

    public Recibos(Integer idRecibos) {
        this.idRecibos = idRecibos;
    }

    public Integer getIdRecibos() {
        return idRecibos;
    }

    public void setIdRecibos(Integer idRecibos) {
        this.idRecibos = idRecibos;
    }

    public Ventas getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Ventas idVentas) {
        this.idVentas = idVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecibos != null ? idRecibos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recibos)) {
            return false;
        }
        Recibos other = (Recibos) object;
        if ((this.idRecibos == null && other.idRecibos != null) || (this.idRecibos != null && !this.idRecibos.equals(other.idRecibos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Recibos[ idRecibos=" + idRecibos + " ]";
    }
    
}
