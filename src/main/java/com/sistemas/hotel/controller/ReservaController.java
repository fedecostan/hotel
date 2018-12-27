package com.sistemas.hotel.controller;

import com.sistemas.hotel.model.Habitacion;
import com.sistemas.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservaController")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @RequestMapping(value = "/habitacionDisponible", method = RequestMethod.GET)
    public @ResponseBody
    List<Habitacion> habitacionDisponible(@RequestParam("fechaDesde") Date fechaDesde, @RequestParam("fechaHasta") Date fechaHasta){
        return reservaService.buscarHabitacionesDisponibles(fechaDesde,fechaHasta);
    }

}
