package com.sistemas.facturacion.controller;

import com.sistemas.facturacion.service.*;
import com.sistemas.facturacion.service.dto.DelegacionDTO;
import com.sistemas.facturacion.service.dto.InfoPantallaDTO;
import com.sistemas.facturacion.service.dto.TipoComprobanteDTO;
import com.sistemas.facturacion.service.dto.TitularDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturaController")
public class FacturaController {

    @Autowired
    private TipoComprobanteService tipoComprobanteService;

    @Autowired
    private SituacionesIVAService situacionesIVAService;

    @Autowired
    private CondicionVentaService condicionVentaService;

    @Autowired
    private DelegacionService delegacionService;

    @Autowired
    private TitularService titularService;

    @RequestMapping(value = "/cargarInformacion", method = RequestMethod.GET)
    public @ResponseBody
    InfoPantallaDTO cargarInformacion(){
        InfoPantallaDTO infoPantallaDTO = new InfoPantallaDTO();
        infoPantallaDTO.setTipoComprobanteDTOList(tipoComprobanteService.obtenerTodos());
        infoPantallaDTO.setSituacionesIVADTOList(situacionesIVAService.obtenerTodos());
        infoPantallaDTO.setCondicionVentaDTOList(condicionVentaService.obtenerTodos());
        return infoPantallaDTO;
    }

    @RequestMapping(value = "/cargarLeyendaComprobante", method = RequestMethod.GET)
    public @ResponseBody
    TipoComprobanteDTO cargarLeyendaComprobante(@RequestParam("codigo") String codigo){
        return tipoComprobanteService.obtenerleyenda(codigo);
    }

    @RequestMapping(value = "/cargarSindicatos", method = RequestMethod.GET)
    public @ResponseBody
    List<DelegacionDTO> cargarSindicatos(){
        return delegacionService.obtenerTodos();
    }

    @RequestMapping(value = "/buscarSindicatoPorCodigo", method = RequestMethod.GET)
    public @ResponseBody
    DelegacionDTO buscarSindicatoPorCodigo(@RequestParam("codigo") String codigo){
        return delegacionService.buscarDelegacionPorCodigo(codigo);
    }

    @RequestMapping(value = "/cargarAfiliados", method = RequestMethod.GET)
    public @ResponseBody
    List<TitularDTO> cargarAfiliados(){
        return titularService.obtenerTodos();
    }

    @RequestMapping(value = "/cargarAfiliadosPorSindicato", method = RequestMethod.GET)
    public @ResponseBody
    List<TitularDTO> cargarAfiliadosPorSindicato(@RequestParam("sindicato") String sindicato){
        return titularService.obtenerPorSindicato(sindicato);
    }

    @RequestMapping(value = "/buscarAfiliadoPorId", method = RequestMethod.GET)
    public @ResponseBody
    TitularDTO buscarAfiliadoPorId(@RequestParam("id") Long id){
        return titularService.obtenerPorId(id);
    }

    @RequestMapping(value = "/buscarAfiliadoPorIdYSindicato", method = RequestMethod.GET)
    public @ResponseBody
    TitularDTO buscarAfiliadoPorIdYSindicato(@RequestParam("id") Long id, @RequestParam("sindicato") Long sindicato){
        return titularService.obtenerPorIdYSindicato(id,sindicato);
    }

//    @RequestMapping(value = "/cargarProductos", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Producto> cargarProductos(@RequestParam("fecha") String fecha){
//        return productoService.obtenerTodos(fecha);
//    }
//
//    @RequestMapping(value = "/cargarProductosPorId", method = RequestMethod.GET)
//    public @ResponseBody
//    Producto cargarProductosPorId(@RequestParam("id") Long id, @RequestParam("fecha") String fecha){
//        return productoService.obtenerPorId(id, fecha);
//    }

}
