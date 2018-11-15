package com.sistemas.facturacion.service;

import com.sistemas.facturacion.model.Afiliado;

import java.util.List;

public interface AfiliadoService {

    List<Afiliado> obtenerTodos();

    List<Afiliado> obtenerPorSindicato(String sindicato);

    Afiliado obtenerPorId(Long id);

    Afiliado obtenerPorIdYSindicato(Long id, String sindicato);
}
