/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.ohana;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdInventario", query = "SELECT i FROM Inventario i WHERE i.idInventario = :idInventario"),
    @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto"),
    @NamedQuery(name = "Inventario.findByPrecioUnitario", query = "SELECT i FROM Inventario i WHERE i.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Inventario.findByPrecioVenta", query = "SELECT i FROM Inventario i WHERE i.precioVenta = :precioVenta"),
    @NamedQuery(name = "Inventario.findByCantidadEntrante", query = "SELECT i FROM Inventario i WHERE i.cantidadEntrante = :cantidadEntrante"),
    @NamedQuery(name = "Inventario.findByCantidadStock", query = "SELECT i FROM Inventario i WHERE i.cantidadStock = :cantidadStock"),
    @NamedQuery(name = "Inventario.findByFechaIngreso", query = "SELECT i FROM Inventario i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Inventario.findByFechaSalida", query = "SELECT i FROM Inventario i WHERE i.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Inventario.findByLote", query = "SELECT i FROM Inventario i WHERE i.lote = :lote"),
    @NamedQuery(name = "Inventario.findByCantidadSaliente", query = "SELECT i FROM Inventario i WHERE i.cantidadSaliente = :cantidadSaliente")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInventario")
    private Integer idInventario;
    @Column(name = "idProducto")
    private Integer idProducto;
    @Column(name = "precioUnitario")
    private Integer precioUnitario;
    @Column(name = "precioVenta")
    private Integer precioVenta;
    @Column(name = "cantidadEntrante")
    private Integer cantidadEntrante;
    @Column(name = "cantidadStock")
    private Integer cantidadStock;
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(name = "lote")
    private Integer lote;
    @Column(name = "cantidadSaliente")
    private Integer cantidadSaliente;
    @JoinColumn(name = "idProductos", referencedColumnName = "idProducto")
    @ManyToOne
    private Productos idProductos;
    @JoinColumn(name = "nit", referencedColumnName = "nit")
    @ManyToOne
    private Proveedores nit;
    @JoinColumn(name = "idVentas", referencedColumnName = "idVentas")
    @ManyToOne
    private Ventas idVentas;

    public Inventario() {
    }

    public Inventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadEntrante() {
        return cantidadEntrante;
    }

    public void setCantidadEntrante(Integer cantidadEntrante) {
        this.cantidadEntrante = cantidadEntrante;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getCantidadSaliente() {
        return cantidadSaliente;
    }

    public void setCantidadSaliente(Integer cantidadSaliente) {
        this.cantidadSaliente = cantidadSaliente;
    }

    public Productos getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Productos idProductos) {
        this.idProductos = idProductos;
    }

    public Proveedores getNit() {
        return nit;
    }

    public void setNit(Proveedores nit) {
        this.nit = nit;
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
        hash += (idInventario != null ? idInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idInventario == null && other.idInventario != null) || (this.idInventario != null && !this.idInventario.equals(other.idInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Inventario[ idInventario=" + idInventario + " ]";
    }
    
}
