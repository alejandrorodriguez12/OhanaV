/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.ohana;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByIdCompras", query = "SELECT c FROM Compras c WHERE c.idCompras = :idCompras"),
    @NamedQuery(name = "Compras.findByIdClientes", query = "SELECT c FROM Compras c WHERE c.idClientes = :idClientes"),
    @NamedQuery(name = "Compras.findByFechaCompras", query = "SELECT c FROM Compras c WHERE c.fechaCompras = :fechaCompras"),
    @NamedQuery(name = "Compras.findByMonto", query = "SELECT c FROM Compras c WHERE c.monto = :monto"),
    @NamedQuery(name = "Compras.findByEstado", query = "SELECT c FROM Compras c WHERE c.estado = :estado")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompras")
    private Integer idCompras;
    @Column(name = "idClientes")
    private Integer idClientes;
    @Size(max = 11)
    @Column(name = "FechaCompras")
    private String fechaCompras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto")
    private Double monto;
    @Size(max = 45)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pago idPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompras", fetch = FetchType.LAZY)
    private Collection<DetalleCompras> detalleComprasCollection;

    public Compras() {
    }

    public Compras(Integer idCompras) {
        this.idCompras = idCompras;
    }

    public Integer getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(Integer idCompras) {
        this.idCompras = idCompras;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getFechaCompras() {
        return fechaCompras;
    }

    public void setFechaCompras(String fechaCompras) {
        this.fechaCompras = fechaCompras;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    @XmlTransient
    public Collection<DetalleCompras> getDetalleComprasCollection() {
        return detalleComprasCollection;
    }

    public void setDetalleComprasCollection(Collection<DetalleCompras> detalleComprasCollection) {
        this.detalleComprasCollection = detalleComprasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompras != null ? idCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idCompras == null && other.idCompras != null) || (this.idCompras != null && !this.idCompras.equals(other.idCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Compras[ idCompras=" + idCompras + " ]";
    }
    
}
