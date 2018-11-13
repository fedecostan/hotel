package com.sistemas.facturacion.service;

import com.sistemas.facturacion.model.TipoComprobante;

import java.util.List;

public interface TipoComprobanteService {

    List<TipoComprobante> obtenerTodos();

    void inicializar();

}
