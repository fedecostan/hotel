package com.sistemas.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "articulop")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ArticuloP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rubroarticulo")
    private String rubroArticulo;

    @Column(name = "fechadesde")
    private String articulo;

    @Column(name = "fechahasta")
    private String descripcion;

    @Column(name = "importea")
    private Double importeA;

    @Column(name = "importeb")
    private Double importeB;

    @Column(name = "importec")
    private Double importeC;

    public String getRubroArticulo() {
        return rubroArticulo;
    }

    public void setRubroArticulo(String rubroArticulo) {
        this.rubroArticulo = rubroArticulo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
