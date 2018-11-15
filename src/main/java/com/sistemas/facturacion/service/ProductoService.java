package com.sistemas.facturacion.service;

import com.sistemas.facturacion.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> obtenerTodos(String fecha);

    Producto obtenerPorId(Long id, String fecha);
}
