package com.sistemas.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "titularesa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TitularA {

    @Id
    @Column(name = "delegacion")
    private String delegacion;

    @Column(name = "fechaalta")
    private String fechaAlta;

    @Column(name = "fechabaja")
    private String fechaBaja;

    @Column(name = "motbaja")
    private String motivoBaja;

    @Column(name = "usualta")
    private String usuarioAlta;

    @Column(name = "fecalta")
    private String fechaUsuarioAlta;

    @Column(name = "usumodi")
    private String usuarioModificacion;

    @Column(name = "fecmodi")
    private String fechaUsuarioModificacion;

    @Column(name = "marca")
    private String marca;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "beneficiario")
    private String beneficiario;

    @JoinColumn(name = "nroregistro")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Titular.class, cascade=CascadeType.ALL)
    private Titular titular;

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getFechaUsuarioAlta() {
        return fechaUsuarioAlta;
    }

    public void setFechaUsuarioAlta(String fechaUsuarioAlta) {
        this.fechaUsuarioAlta = fechaUsuarioAlta;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaUsuarioModificacion() {
        return fechaUsuarioModificacion;
    }

    public void setFechaUsuarioModificacion(String fechaUsuarioModificacion) {
        this.fechaUsuarioModificacion = fechaUsuarioModificacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }
}
