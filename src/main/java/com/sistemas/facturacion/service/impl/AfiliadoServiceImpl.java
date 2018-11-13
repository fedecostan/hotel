package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Afiliado;
import com.sistemas.facturacion.repository.AfiliadoRepository;
import com.sistemas.facturacion.service.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Override
    public List<Afiliado> obtenerTodos() {
        return afiliadoRepository.findAll();
    }

    @Override
    public List<Afiliado> obtenerPorSindicato(String sindicato) {
        return afiliadoRepository.findBySindicato(sindicato);
    }

}
