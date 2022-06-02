/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.ohana;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josea
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByNumeroCedula", query = "SELECT p FROM Personas p WHERE p.numeroCedula = :numeroCedula"),
    @NamedQuery(name = "Personas.findByPrimerNombre", query = "SELECT p FROM Personas p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Personas.findBySegundoNombre", query = "SELECT p FROM Personas p WHERE p.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Personas.findByPrimerApellido", query = "SELECT p FROM Personas p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Personas.findBySegundoApellido", query = "SELECT p FROM Personas p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Personas.findByCorreo", query = "SELECT p FROM Personas p WHERE p.correo = :correo"),
    @NamedQuery(name = "Personas.findByNumeroCelular", query = "SELECT p FROM Personas p WHERE p.numeroCelular = :numeroCelular"),
    @NamedQuery(name = "Personas.findByTipoDeVia", query = "SELECT p FROM Personas p WHERE p.tipoDeVia = :tipoDeVia"),
    @NamedQuery(name = "Personas.findByNumeroVia", query = "SELECT p FROM Personas p WHERE p.numeroVia = :numeroVia"),
    @NamedQuery(name = "Personas.findByLetraVia", query = "SELECT p FROM Personas p WHERE p.letraVia = :letraVia"),
    @NamedQuery(name = "Personas.findByNumero", query = "SELECT p FROM Personas p WHERE p.numero = :numero"),
    @NamedQuery(name = "Personas.findByLetra", query = "SELECT p FROM Personas p WHERE p.letra = :letra"),
    @NamedQuery(name = "Personas.findByNumeroApto", query = "SELECT p FROM Personas p WHERE p.numeroApto = :numeroApto"),
    @NamedQuery(name = "Personas.findByFechaDeNacimiento", query = "SELECT p FROM Personas p WHERE p.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Personas.findByContrasenia", query = "SELECT p FROM Personas p WHERE p.contrasenia = :contrasenia")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroCedula")
    private Integer numeroCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 15)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Column(name = "numeroCelular")
    private BigInteger numeroCelular;
    @Size(max = 7)
    @Column(name = "tipoDeVia")
    private String tipoDeVia;
    @Column(name = "numeroVia")
    private Integer numeroVia;
    @Size(max = 1)
    @Column(name = "letraVia")
    private String letraVia;
    @Size(max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 1)
    @Column(name = "letra")
    private String letra;
    @Size(max = 20)
    @Column(name = "numeroApto")
    private String numeroApto;
    @Column(name = "fechaDeNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contrasenia")
    private String contrasenia;
    @JoinTable(name = "roles_personas", joinColumns = {
        @JoinColumn(name = "numeroCedula", referencedColumnName = "numeroCedula"),
        @JoinColumn(name = "numeroCedula", referencedColumnName = "numeroCedula")}, inverseJoinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Roles> rolesCollection;
    @OneToMany(mappedBy = "personas", fetch = FetchType.LAZY)
    private Collection<Encargadosdelinventario> encargadosdelinventarioCollection;
    @JoinColumn(name = "numeroLocalidad", referencedColumnName = "numeroLocalidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localidades numeroLocalidad;
    @OneToMany(mappedBy = "personas", fetch = FetchType.LAZY)
    private Collection<Clientes> clientesCollection;

    public Personas() {
    }

    public Personas(Integer numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public Personas(Integer numeroCedula, String primerNombre, String primerApellido, String contrasenia) {
        this.numeroCedula = numeroCedula;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.contrasenia = contrasenia;
    }

    public Integer getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Integer numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public BigInteger getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(BigInteger numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getTipoDeVia() {
        return tipoDeVia;
    }

    public void setTipoDeVia(String tipoDeVia) {
        this.tipoDeVia = tipoDeVia;
    }

    public Integer getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(Integer numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getLetraVia() {
        return letraVia;
    }

    public void setLetraVia(String letraVia) {
        this.letraVia = letraVia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getNumeroApto() {
        return numeroApto;
    }

    public void setNumeroApto(String numeroApto) {
        this.numeroApto = numeroApto;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<Encargadosdelinventario> getEncargadosdelinventarioCollection() {
        return encargadosdelinventarioCollection;
    }

    public void setEncargadosdelinventarioCollection(Collection<Encargadosdelinventario> encargadosdelinventarioCollection) {
        this.encargadosdelinventarioCollection = encargadosdelinventarioCollection;
    }

    public Localidades getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Localidades numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCedula != null ? numeroCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.numeroCedula == null && other.numeroCedula != null) || (this.numeroCedula != null && !this.numeroCedula.equals(other.numeroCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Personas[ numeroCedula=" + numeroCedula + " ]";
    }
    
}
