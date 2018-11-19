package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.Titular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitularRepository extends JpaRepository<Titular, Long> {

    @Query("select t from Titular t" +
            " inner join t.titularAList ta" +
            " where ta.delegacion = ?1")
    List<Titular> findBySindicato(String sindicato);

    Titular findByNumeroRegistro(String formattedNumber);

    @Query("select t from Titular t" +
            " inner join t.titularAList ta" +
            " where t.numeroRegistro = ?1" +
            " and ta.delegacion = ?2")
    Titular findByNumeroRegistroAndSindicato(String formattedTitular, String formattedSindicato);
}
