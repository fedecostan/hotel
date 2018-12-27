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

}
