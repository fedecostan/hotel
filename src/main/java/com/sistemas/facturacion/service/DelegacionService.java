package com.sistemas.facturacion.service;

import com.sistemas.facturacion.service.dto.DelegacionDTO;

import java.util.List;

public interface DelegacionService {

    List<DelegacionDTO> obtenerTodos();

    DelegacionDTO buscarDelegacionPorCodigo(String codigo);
}
