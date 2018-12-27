package com.sistemas.hotel.service;

import com.sistemas.hotel.model.Habitacion;

import java.util.Date;
import java.util.List;

public interface ReservaService {

    List<Habitacion> buscarHabitacionesDisponibles(Date fechaDesde, Date fechaHasta);
}
