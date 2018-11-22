package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.CondicionVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondicionVentaRepository extends JpaRepository<CondicionVenta, Long> {

    @Query(value = "SELECT * FROM tcondvent", nativeQuery = true)
    List<CondicionVenta> findTodos();
}
