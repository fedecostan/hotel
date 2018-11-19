package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.CondicionVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionVentaRepository extends JpaRepository<CondicionVenta, Long> {

}
