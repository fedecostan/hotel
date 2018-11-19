package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Delegacion;
import com.sistemas.facturacion.model.TipoComprobante;
import com.sistemas.facturacion.repository.DelegacionRepository;
import com.sistemas.facturacion.service.DelegacionService;
import com.sistemas.facturacion.service.dto.DelegacionDTO;
import com.sistemas.facturacion.service.dto.TipoComprobanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DelegacionServiceImpl implements DelegacionService {

    @Autowired
    private DelegacionRepository delegacionRepository;

    @Override
    public List<DelegacionDTO> obtenerTodos() {
        List<Delegacion> delegacionList = delegacionRepository.findAll();
        List<DelegacionDTO> delegacionDTOList = new ArrayList<>();
        for (Delegacion delegacion : delegacionList){
            DelegacionDTO delegacionDTO = new DelegacionDTO();
            delegacionDTO.setName(delegacion.getNombre());
            delegacionDTO.setValue(delegacion.getCodigo());
            delegacionDTO.setCuit(delegacion.getCuit());
            delegacionDTOList.add(delegacionDTO);
        }
        return delegacionDTOList;
    }

    @Override
    public DelegacionDTO buscarDelegacionPorCodigo(String codigo) {
        Delegacion delegacion = delegacionRepository.findByCodigo(codigo);
        DelegacionDTO delegacionDTO = new DelegacionDTO();
        if (delegacion!=null){
            delegacionDTO.setName(delegacion.getNombre());
            delegacionDTO.setValue(delegacion.getCodigo());
            delegacionDTO.setCuit(delegacion.getCuit());
        } else {
            delegacionDTO.setName("NO EXISTE");
        }
        return delegacionDTO;
    }

}
