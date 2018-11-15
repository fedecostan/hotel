package com.sistemas.facturacion.controller;

import com.sistemas.facturacion.model.Afiliado;
import com.sistemas.facturacion.model.Sindicato;
import com.sistemas.facturacion.service.*;
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

    @Autowired
    private SituacionIvaService situacionIvaService;

    @Autowired
    private CondicionVentaService condicionVentaService;

    @RequestMapping(value = "/inicializarData", method = RequestMethod.GET)
    public void inicializar(){
        tipoComprobanteService.inicializar();
    }

    @RequestMapping(value = "/cargarInformacion", method = RequestMethod.GET)
    public @ResponseBody
    InfoPantallaDTO cargarInformacion(){
        InfoPantallaDTO infoPantallaDTO = new InfoPantallaDTO();
        infoPantallaDTO.setTipoComprobanteList(tipoComprobanteService.obtenerTodos());
        infoPantallaDTO.setSituacionIvaList(situacionIvaService.obtenerTodos());
        infoPantallaDTO.setCondicionVentaList(condicionVentaService.obtenerTodos());
        return infoPantallaDTO;
    }

    @RequestMapping(value = "/cargarSindicatos", method = RequestMethod.GET)
    public @ResponseBody
    List<Sindicato> cargarSindicatos(){
        return sindicatoService.obtenerTodos();
    }

    @RequestMapping(value = "/buscarSindicatoPorCodigo", method = RequestMethod.GET)
    public @ResponseBody
    Sindicato buscarSindicatoPorCodigo(@RequestParam("codigo") String codigo){
        return sindicatoService.buscarSindicatoPorCodigo(codigo);
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

    @RequestMapping(value = "/buscarAfiliadoPorId", method = RequestMethod.GET)
    public @ResponseBody
    Afiliado cargarAfiliadosPorSindicato(@RequestParam("id") Long id){
        return afiliadoService.obtenerPorId(id);
    }

    @RequestMapping(value = "/buscarAfiliadoPorIdYSindicato", method = RequestMethod.GET)
    public @ResponseBody
    Afiliado cargarAfiliadosPorSindicato(@RequestParam("id") Long id, @RequestParam("sindicato") String sindicato){
        return afiliadoService.obtenerPorIdYSindicato(id,sindicato);
    }

}
