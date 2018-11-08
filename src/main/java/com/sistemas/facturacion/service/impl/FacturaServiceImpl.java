package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.repository.FacturaRepository;
import com.sistemas.facturacion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

}
