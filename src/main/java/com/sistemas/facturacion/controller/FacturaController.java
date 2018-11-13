package com.sistemas.facturacion.controller;

import com.sistemas.facturacion.model.Afiliado;
import com.sistemas.facturacion.model.Sindicato;
import com.sistemas.facturacion.service.AfiliadoService;
import com.sistemas.facturacion.service.SindicatoService;
import com.sistemas.facturacion.service.TipoComprobanteService;
import com.sistemas.facturacion.service.dto.InfoPantallaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturaController")
public class FacturaController {

    @Autowired
    private TipoComprobanteService tipoComprobanteService;

    @Autowired
    private SindicatoService sindicatoService;

    @Autowired
    private AfiliadoService afiliadoService;

    @RequestMapping(value = "/inicializarData", method = RequestMethod.GET)
    public void inicializar(){
        tipoComprobanteService.inicializar();
    }

    @RequestMapping(value = "/cargarInformacion", method = RequestMethod.GET)
    public @ResponseBody
    InfoPantallaDTO cargarInformacion(){
        InfoPantallaDTO infoPantallaDTO = new InfoPantallaDTO();
        infoPantallaDTO.setTipoComprobanteList(tipoComprobanteService.obtenerTodos());
        return infoPantallaDTO;
    }

    @RequestMapping(value = "/cargarSindicatos", method = RequestMethod.GET)
    public @ResponseBody
    List<Sindicato> cargarSindicatos(){
        return sindicatoService.obtenerTodos();
    }

    @RequestMapping(value = "/cargarAfiliados", method = RequestMethod.GET)
    public @ResponseBody
    List<Afiliado> cargarAfiliados(){
        return afiliadoService.obtenerTodos();
    }

    @RequestMapping(value = "/cargarAfiliadosPorSindicato", method = RequestMethod.GET)
    public @ResponseBody
    List<Afiliado> cargarAfiliadosPorSindicato(@RequestParam("sindicato") String sindicato){
        return afiliadoService.obtenerPorSindicato(sindicato);
    }

}
