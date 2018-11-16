package com.sistemas.facturacion.repository;

import com.sistemas.facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("select p from Producto p where p.id = ?1" +
            " and p.fechaDesde < STR_TO_DATE(?2,'%d/%m/%Y')" +
            " and p.fechaHasta > STR_TO_DATE(?2,'%d/%m/%Y')")
    Producto findOneByIdAndFecha(Long id, String fecha);

    @Query("select p from Producto p where" +
            " p.fechaDesde < STR_TO_DATE(?1,'%d/%m/%Y')" +
            " and p.fechaHasta > STR_TO_DATE(?1,'%d/%m/%Y')")
    List<Producto> findByFecha(String fecha);
}
