package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Afiliado;
import com.sistemas.facturacion.model.Sindicato;
import com.sistemas.facturacion.model.TipoComprobante;
import com.sistemas.facturacion.repository.AfiliadoRepository;
import com.sistemas.facturacion.repository.SindicatoRepository;
import com.sistemas.facturacion.repository.TipoComprobanteRepository;
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
    }
}
