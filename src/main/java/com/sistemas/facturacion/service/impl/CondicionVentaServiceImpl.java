package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.CondicionVenta;
import com.sistemas.facturacion.repository.CondicionVentaRepository;
import com.sistemas.facturacion.service.CondicionVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionVentaServiceImpl implements CondicionVentaService {

    @Autowired
    private CondicionVentaRepository condicionVentaRepository;

    @Override
    public List<CondicionVenta> obtenerTodos() {
        return condicionVentaRepository.findAll();
    }
}
