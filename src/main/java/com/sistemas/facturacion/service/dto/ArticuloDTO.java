package com.sistemas.facturacion.service.dto;

public class ArticuloDTO {

    private String value;
    private String name;
    private Long stock;
    private Double precioA;
    private Double precioB;
    private Double precioC;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
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
