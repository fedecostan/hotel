package com.sistemas.facturacion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facturaController")
public class FacturaController {

//    @Autowired
//    private TipoComprobanteService tipoComprobanteService;
//
//    @RequestMapping(value = "/inicializarData", method = RequestMethod.GET)
//    public void inicializar(){
//        tipoComprobanteService.inicializar();
//    }
//
//    @RequestMapping(value = "/cargarInformacion", method = RequestMethod.GET)
//    public @ResponseBody
//    InfoPantallaDTO cargarInformacion(){
//        InfoPantallaDTO infoPantallaDTO = new InfoPantallaDTO();
//        infoPantallaDTO.setTipoComprobanteList(tipoComprobanteService.obtenerTodos());
//        infoPantallaDTO.setSituacionIvaList(situacionIvaService.obtenerTodos());
//        infoPantallaDTO.setCondicionVentaList(condicionVentaService.obtenerTodos());
//        return infoPantallaDTO;
//    }
//
//    @RequestMapping(value = "/cargarLeyendaComprobante", method = RequestMethod.GET)
//    public @ResponseBody
//    TipoComprobante cargarLeyendaComprobante(@RequestParam("codigo") String codigo){
//        return tipoComprobanteService.obtenerleyenda(codigo);
//    }
//
//    @RequestMapping(value = "/cargarSindicatos", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Sindicato> cargarSindicatos(){
//        return sindicatoService.obtenerTodos();
//    }
//
//    @RequestMapping(value = "/buscarSindicatoPorCodigo", method = RequestMethod.GET)
//    public @ResponseBody
//    Sindicato buscarSindicatoPorCodigo(@RequestParam("codigo") String codigo){
//        return sindicatoService.buscarSindicatoPorCodigo(codigo);
//    }
//
//    @RequestMapping(value = "/cargarAfiliados", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Afiliado> cargarAfiliados(){
//        return afiliadoService.obtenerTodos();
//    }
//
//    @RequestMapping(value = "/cargarAfiliadosPorSindicato", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Afiliado> cargarAfiliadosPorSindicato(@RequestParam("sindicato") String sindicato){
//        return afiliadoService.obtenerPorSindicato(sindicato);
//    }
//
//    @RequestMapping(value = "/buscarAfiliadoPorId", method = RequestMethod.GET)
//    public @ResponseBody
//    Afiliado cargarAfiliadosPorSindicato(@RequestParam("id") Long id){
//        return afiliadoService.obtenerPorId(id);
//    }
//
//    @RequestMapping(value = "/buscarAfiliadoPorIdYSindicato", method = RequestMethod.GET)
//    public @ResponseBody
//    Afiliado cargarAfiliadosPorSindicato(@RequestParam("id") Long id, @RequestParam("sindicato") String sindicato){
//        return afiliadoService.obtenerPorIdYSindicato(id,sindicato);
//    }
//
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
