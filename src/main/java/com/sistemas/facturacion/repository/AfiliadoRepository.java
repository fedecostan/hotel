package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {

    List<Afiliado> findBySindicato(String sindicato);

    @Query("select a from Afiliado a where a.id = ?1")
    Afiliado findOne(Long id);
}
