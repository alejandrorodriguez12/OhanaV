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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "carritodecompras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carritodecompras.findAll", query = "SELECT c FROM Carritodecompras c"),
    @NamedQuery(name = "Carritodecompras.findByIdcarrito", query = "SELECT c FROM Carritodecompras c WHERE c.idcarrito = :idcarrito")})
public class Carritodecompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarrito")
    private Integer idcarrito;
    @OneToMany(mappedBy = "idCarrito")
    private Collection<ItemCarrito> itemCarritoCollection;
    @JoinColumn(name = "idCliente", referencedColumnName = "idClientes")
    @ManyToOne
    private Clientes idCliente;
    @JoinColumns({
        @JoinColumn(name = "numeroCedula", referencedColumnName = "numeroCedula"),
        @JoinColumn(name = "numeroCedula", referencedColumnName = "numeroCedula")})
    @ManyToOne
    private Personas personas;

    public Carritodecompras() {
    }

    public Carritodecompras(Integer idcarrito) {
        this.idcarrito = idcarrito;
    }

    public Integer getIdcarrito() {
        return idcarrito;
    }

    public void setIdcarrito(Integer idcarrito) {
        this.idcarrito = idcarrito;
    }

    @XmlTransient
    public Collection<ItemCarrito> getItemCarritoCollection() {
        return itemCarritoCollection;
    }

    public void setItemCarritoCollection(Collection<ItemCarrito> itemCarritoCollection) {
        this.itemCarritoCollection = itemCarritoCollection;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
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
        hash += (idcarrito != null ? idcarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carritodecompras)) {
            return false;
        }
        Carritodecompras other = (Carritodecompras) object;
        if ((this.idcarrito == null && other.idcarrito != null) || (this.idcarrito != null && !this.idcarrito.equals(other.idcarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Carritodecompras[ idcarrito=" + idcarrito + " ]";
    }
    
}
