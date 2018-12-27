package com.sistemas.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESERVA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;

    @Column(name = "FECHA_SALIDA")
    private Date fechaSalida;

    @JoinColumn(name="HABITACION")
    private Habitacion habitacion;

    @JoinColumn(name="HUESPED")
    private Huesped huesped;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
}
