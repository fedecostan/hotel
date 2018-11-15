package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.SituacionIva;
import com.sistemas.facturacion.repository.SituacionIvaRepository;
import com.sistemas.facturacion.service.SituacionIvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacionIvaServiceImpl implements SituacionIvaService {

    @Autowired
    private SituacionIvaRepository situacionIvaRepository;

    @Override
    public List<SituacionIva> obtenerTodos() {
        return situacionIvaRepository.findAll();
    }
}
