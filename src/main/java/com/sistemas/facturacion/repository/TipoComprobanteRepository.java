package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.TipoComprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoComprobanteRepository extends JpaRepository<TipoComprobante, Long> {

    TipoComprobante findByCodigo(String codigo);
}
