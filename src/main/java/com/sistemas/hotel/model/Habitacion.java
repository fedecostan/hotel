package com.sistemas.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "HABITACION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Habitacion {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMERO")
    private Integer numero;

    @JoinColumn(name="TIPO")
    private TipoHabitacion tipoHabitacion;

    @Column(name = "CAPACIDAD")
    private Integer capacidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
