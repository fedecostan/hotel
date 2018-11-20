package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.repository.ArticuloCRepository;
import com.sistemas.facturacion.service.ArticuloCService;
import com.sistemas.facturacion.service.dto.ArticuloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloCServiceImpl implements ArticuloCService {

    @Autowired
    private ArticuloCRepository articuloCRepository;

    @Override
    public List<ArticuloDTO> obtenerTodos(String fecha) {
        return null;
    }
}
