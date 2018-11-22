package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.TipoComprobante;
import com.sistemas.facturacion.repository.TipoComprobanteRepository;
import com.sistemas.facturacion.service.TipoComprobanteService;
import com.sistemas.facturacion.service.dto.TipoComprobanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    @Override
    public List<TipoComprobanteDTO> obtenerTodos() {
        List<TipoComprobante> tipoComprobanteList = tipoComprobanteRepository.findTodos();
        List<TipoComprobanteDTO> tipoComprobanteDTOList = new ArrayList<>();
        for (TipoComprobante tipoComprobante : tipoComprobanteList){
            TipoComprobanteDTO tipoComprobanteDTO = new TipoComprobanteDTO();
            tipoComprobanteDTO.setName(tipoComprobante.getDescripcion());
            tipoComprobanteDTO.setValue(tipoComprobante.getCodigo());
            tipoComprobanteDTOList.add(tipoComprobanteDTO);
        }
        return tipoComprobanteDTOList;
    }

    @Override
    public TipoComprobanteDTO obtenerleyenda(String codigo) {
        TipoComprobante tipoComprobante = tipoComprobanteRepository.findByCodigo(codigo);
        TipoComprobanteDTO tipoComprobanteDTO = new TipoComprobanteDTO();
        tipoComprobanteDTO.setName(tipoComprobante.getLeyenda());
        return tipoComprobanteDTO;
    }
}
