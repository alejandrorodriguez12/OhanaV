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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "encargadosdelinventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encargadosdelinventario.findAll", query = "SELECT e FROM Encargadosdelinventario e"),
    @NamedQuery(name = "Encargadosdelinventario.findByIdEncargadoDelInventario", query = "SELECT e FROM Encargadosdelinventario e WHERE e.idEncargadoDelInventario = :idEncargadoDelInventario")})
public class Encargadosdelinventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEncargadoDelInventario")
    private Integer idEncargadoDelInventario;
    @JoinColumns({
        @JoinColumn(name = "numeroCedula", referencedColumnName = "numeroCedula"),
        @JoinColumn(name = "numeroCedula", referencedColumnName = "numeroCedula")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Personas personas;

    public Encargadosdelinventario() {
    }

    public Encargadosdelinventario(Integer idEncargadoDelInventario) {
        this.idEncargadoDelInventario = idEncargadoDelInventario;
    }

    public Integer getIdEncargadoDelInventario() {
        return idEncargadoDelInventario;
    }

    public void setIdEncargadoDelInventario(Integer idEncargadoDelInventario) {
        this.idEncargadoDelInventario = idEncargadoDelInventario;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncargadoDelInventario != null ? idEncargadoDelInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encargadosdelinventario)) {
            return false;
        }
        Encargadosdelinventario other = (Encargadosdelinventario) object;
        if ((this.idEncargadoDelInventario == null && other.idEncargadoDelInventario != null) || (this.idEncargadoDelInventario != null && !this.idEncargadoDelInventario.equals(other.idEncargadoDelInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Encargadosdelinventario[ idEncargadoDelInventario=" + idEncargadoDelInventario + " ]";
    }
    
}
