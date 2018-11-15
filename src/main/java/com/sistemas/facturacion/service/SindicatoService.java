package com.sistemas.facturacion.service;

import com.sistemas.facturacion.model.Sindicato;

import java.util.List;

public interface SindicatoService {

    List<Sindicato> obtenerTodos();

    Sindicato buscarSindicatoPorCodigo(String codigo);
}
