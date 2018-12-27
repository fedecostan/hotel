package com.sistemas.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_HABITACION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoHabitacion {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(mappedBy = "tipoHabitacion")
    private List<Habitacion> habitacionList;

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

    public List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<Habitacion> habitacionList) {
        this.habitacionList = habitacionList;
    }
}
