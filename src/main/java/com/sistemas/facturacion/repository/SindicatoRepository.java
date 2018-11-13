package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.Sindicato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SindicatoRepository extends JpaRepository<Sindicato, Long> {

}
