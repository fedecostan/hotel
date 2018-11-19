package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.SituacionesIVA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacionesIVARepository extends JpaRepository<SituacionesIVA, Long> {

}
