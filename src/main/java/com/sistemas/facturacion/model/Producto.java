package com.sistemas.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "STOCK")
    private int stock;

    @Column(name = "PRECIO_A")
    private Double precioA;

    @Column(name = "PRECIO_B")
    private Double precioB;

    @Column(name = "PRECIO_C")
    private Double precioC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecioA() {
        return precioA;
    }

    public void setPrecioA(Double precioA) {
        this.precioA = precioA;
    }

    public Double getPrecioB() {
        return precioB;
    }

    public void setPrecioB(Double precioB) {
        this.precioB = precioB;
    }

    public Double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(Double precioC) {
        this.precioC = precioC;
    }
}
