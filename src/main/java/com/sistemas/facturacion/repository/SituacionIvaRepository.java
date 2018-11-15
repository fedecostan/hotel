package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.SituacionIva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacionIvaRepository extends JpaRepository<SituacionIva, Long> {

}
