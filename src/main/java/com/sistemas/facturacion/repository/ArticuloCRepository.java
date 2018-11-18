package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.ArticuloC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloCRepository extends JpaRepository<ArticuloC, Long> {

}
