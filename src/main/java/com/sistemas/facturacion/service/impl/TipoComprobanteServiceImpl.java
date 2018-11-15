package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.*;
import com.sistemas.facturacion.repository.*;
import com.sistemas.facturacion.service.TipoComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    @Autowired
    private SindicatoRepository sindicatoRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private SituacionIvaRepository situacionIvaRepository;

    @Autowired
    private CondicionVentaRepository condicionVentaRepository;

    @Override
    public List<TipoComprobante> obtenerTodos() {
        return tipoComprobanteRepository.findAll();
    }

    @Override
    public void inicializar() {
        TipoComprobante tipoComprobante1 = new TipoComprobante();
        tipoComprobante1.setCodigo("FC");
        tipoComprobante1.setCodigoAfip(111);
        tipoComprobante1.setDescripcion("Factura C");
        tipoComprobante1.setLeyenda("Leyenda Factura C");
        tipoComprobante1.setTipo("C");
        TipoComprobante tipoComprobante2 = new TipoComprobante();
        tipoComprobante2.setCodigo("NCC");
        tipoComprobante2.setCodigoAfip(222);
        tipoComprobante2.setDescripcion("Nota de Credito C");
        tipoComprobante2.setLeyenda("Leyenda Nota de Credito C");
        tipoComprobante2.setTipo("C");
        TipoComprobante tipoComprobante3 = new TipoComprobante();
        tipoComprobante3.setCodigo("NDC");
        tipoComprobante3.setCodigoAfip(333);
        tipoComprobante3.setDescripcion("Nota de Debito C");
        tipoComprobante3.setLeyenda("Leyenda Nota de Debito C");
        tipoComprobante3.setTipo("C");
        List<TipoComprobante> tipoComprobanteList = new ArrayList<>();
        tipoComprobanteList.add(tipoComprobante1);
        tipoComprobanteList.add(tipoComprobante2);
        tipoComprobanteList.add(tipoComprobante3);
        tipoComprobanteRepository.saveAll(tipoComprobanteList);
        Sindicato sindicato1 = new Sindicato();
        sindicato1.setCodigo("111");
        sindicato1.setNombre("Petrolero");
        sindicato1.setCuit("1-37491509-4");
        Sindicato sindicato2 = new Sindicato();
        sindicato2.setCodigo("222");
        sindicato2.setNombre("Camionero");
        sindicato2.setCuit("1-84624731-8");
        Sindicato sindicato3 = new Sindicato();
        sindicato3.setCodigo("333");
        sindicato3.setNombre("Docente");
        sindicato3.setCuit("1-96223065-5");
        List<Sindicato> sindicatoList = new ArrayList<>();
        sindicatoList.add(sindicato1);
        sindicatoList.add(sindicato2);
        sindicatoList.add(sindicato3);
        sindicatoRepository.saveAll(sindicatoList);
        Afiliado afiliado1 = new Afiliado();
        afiliado1.setSindicato("111");
        afiliado1.setNombre("Federico");
        afiliado1.setApellido("Costantino");
        afiliado1.setDni("12345678");
        Afiliado afiliado2 = new Afiliado();
        afiliado2.setSindicato("222");
        afiliado2.setNombre("Elisa");
        afiliado2.setApellido("Cardu");
        afiliado2.setDni("12345678");
        Afiliado afiliado3 = new Afiliado();
        afiliado3.setSindicato("222");
        afiliado3.setNombre("Gabriela");
        afiliado3.setApellido("Cardu");
        afiliado3.setDni("12345678");
        List<Afiliado> afiliadoList = new ArrayList<>();
        afiliadoList.add(afiliado1);
        afiliadoList.add(afiliado2);
        afiliadoList.add(afiliado3);
        afiliadoRepository.saveAll(afiliadoList);
        SituacionIva situacionIva1 = new SituacionIva();
        situacionIva1.setDescripcion("Situacion IVA 1");
        situacionIva1.setCodigoAfip("1");
        SituacionIva situacionIva2 = new SituacionIva();
        situacionIva2.setDescripcion("Situacion IVA 2");
        situacionIva2.setCodigoAfip("2");
        SituacionIva situacionIva3 = new SituacionIva();
        situacionIva3.setDescripcion("Situacion IVA 3");
        situacionIva3.setCodigoAfip("3");
        List<SituacionIva> situacionIvaList = new ArrayList<>();
        situacionIvaList.add(situacionIva1);
        situacionIvaList.add(situacionIva2);
        situacionIvaList.add(situacionIva3);
        situacionIvaRepository.saveAll(situacionIvaList);
        CondicionVenta condicionVenta1 = new CondicionVenta();
        condicionVenta1.setDescripcion("Condicion Venta 1");
        condicionVenta1.setCodigoAfip("1");
        CondicionVenta condicionVenta2 = new CondicionVenta();
        condicionVenta2.setDescripcion("Condicion Venta 2");
        condicionVenta2.setCodigoAfip("2");
        CondicionVenta condicionVenta3 = new CondicionVenta();
        condicionVenta3.setDescripcion("Condicion Venta 3");
        condicionVenta3.setCodigoAfip("3");
        List<CondicionVenta> condicionVentaList = new ArrayList<>();
        condicionVentaList.add(condicionVenta1);
        condicionVentaList.add(condicionVenta2);
        condicionVentaList.add(condicionVenta3);
        condicionVentaRepository.saveAll(condicionVentaList);
    }
}
