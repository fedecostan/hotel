package com.sistemas.hotel.service.impl;

import com.sistemas.hotel.model.Habitacion;
import com.sistemas.hotel.model.Reserva;
import com.sistemas.hotel.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Override
    public List<Habitacion> buscarHabitacionesDisponibles(Date fechaDesde, Date fechaHasta) {
        List<Habitacion> habitacionList = new ArrayList<>(); //TODO: Traer todas las habitaciones
        return descartarOcupadas(habitacionList,fechaDesde,fechaHasta);
    }

    private List<Habitacion> descartarOcupadas(List<Habitacion> habitacionList, Date fechaDesde, Date fechaHasta) {
        List<Habitacion> desocupadas = new ArrayList<>();
        for (Habitacion habitacion : habitacionList){
            Reserva reserva = new Reserva(); //TODO: Buscar reserva con fecha inicio o fin entre las fechas desde y hasta
            if (reserva==null){
                desocupadas.add(habitacion);
            }
        }
        return desocupadas;
    }
}
