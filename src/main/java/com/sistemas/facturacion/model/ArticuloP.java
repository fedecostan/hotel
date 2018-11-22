package com.sistemas.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "articulop")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ArticuloP {

    @Id
    @Column(name = "fechadesde")
    private String fechaDesde;

    @Column(name = "fechahasta")
    private String fechaHasta;

    @Column(name = "importea")
    private Double importeA;

    @Column(name = "importeb")
    private Double importeB;

    @Column(name = "importec")
    private Double importeC;

    @JoinColumn(name = "rubroarticulo")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ArticuloC.class, cascade=CascadeType.ALL)
    private ArticuloC articuloC;

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Double getImporteA() {
        return importeA;
    }

    public void setImporteA(Double importeA) {
        this.importeA = importeA;
    }

    public Double getImporteB() {
        return importeB;
    }

    public void setImporteB(Double importeB) {
        this.importeB = importeB;
    }

    public Double getImporteC() {
        return importeC;
    }

    public void setImporteC(Double importeC) {
        this.importeC = importeC;
    }

    public ArticuloC getArticuloC() {
        return articuloC;
    }

    public void setArticuloC(ArticuloC articuloC) {
        this.articuloC = articuloC;
    }
}