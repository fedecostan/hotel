package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Sindicato;
import com.sistemas.facturacion.repository.SindicatoRepository;
import com.sistemas.facturacion.service.SindicatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SindicatoServiceImpl implements SindicatoService {

    @Autowired
    private SindicatoRepository sindicatoRepository;

    @Override
    public List<Sindicato> obtenerTodos() {
        return sindicatoRepository.findAll();
    }

}
