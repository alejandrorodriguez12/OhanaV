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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "item_carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCarrito.findAll", query = "SELECT i FROM ItemCarrito i"),
    @NamedQuery(name = "ItemCarrito.findByItemId", query = "SELECT i FROM ItemCarrito i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "ItemCarrito.findByCantidad", query = "SELECT i FROM ItemCarrito i WHERE i.cantidad = :cantidad")})
public class ItemCarrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemId")
    private Integer itemId;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "id_Carrito", referencedColumnName = "idcarrito")
    @ManyToOne(fetch = FetchType.LAZY)
    private Carritodecompras idCarrito;
    @JoinColumn(name = "product_id", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Productos productId;

    public ItemCarrito() {
    }

    public ItemCarrito(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Carritodecompras getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Carritodecompras idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Productos getProductId() {
        return productId;
    }

    public void setProductId(Productos productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCarrito)) {
            return false;
        }
        ItemCarrito other = (ItemCarrito) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.ItemCarrito[ itemId=" + itemId + " ]";
    }
    
}
