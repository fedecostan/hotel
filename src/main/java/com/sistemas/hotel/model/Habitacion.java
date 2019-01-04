package com.sistemas.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TipoHabitacion.class, cascade=CascadeType.ALL)
    private TipoHabitacion tipoHabitacion;

    @Column(name = "CAPACIDAD")
    private Integer capacidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "habitacion", targetEntity = Reserva.class, cascade=CascadeType.ALL)
    private List<Reserva> reservaList;

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

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }
}
