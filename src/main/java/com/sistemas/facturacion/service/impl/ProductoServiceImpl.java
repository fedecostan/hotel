package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Producto;
import com.sistemas.facturacion.repository.ProductoRepository;
import com.sistemas.facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerTodos(String fecha) {
        return productoRepository.findByFecha(fecha);
    }

    @Override
    public Producto obtenerPorId(Long id, String fecha) {
        Producto producto = productoRepository.findOneByIdAndFecha(id, fecha);
        if (producto == null){
            producto = new Producto();
            producto.setDescripcion("N/P");
        } else {
            if (producto.getStock() < 1){
                producto.setDescripcion(producto.getDescripcion()+" (SIN STOCK)");
                producto.setPrecioA(null);
                producto.setPrecioB(null);
                producto.setPrecioC(null);
            }
        }
        return producto;
    }
}
