package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Afiliado;
import com.sistemas.facturacion.repository.AfiliadoRepository;
import com.sistemas.facturacion.service.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfiliadoServiceImpl implements AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Override
    public List<Afiliado> obtenerTodos() {
        return afiliadoRepository.findAll();
    }

    @Override
    public List<Afiliado> obtenerPorSindicato(String sindicato) {
        return afiliadoRepository.findBySindicato(sindicato);
    }

    @Override
    public Afiliado obtenerPorId(Long id) {
        Afiliado afiliado = afiliadoRepository.findOne(id);
        if (afiliado == null){
            afiliado = new Afiliado();
            afiliado.setNombre("N/A");
            afiliado.setDni("");
        }
        return afiliado;
    }

    @Override
    public Afiliado obtenerPorIdYSindicato(Long id, String sindicato) {
        Afiliado afiliado = afiliadoRepository.findOne(id);
        if (afiliado == null || !afiliado.getSindicato().equals(sindicato)){
            afiliado = new Afiliado();
            afiliado.setNombre("N/A");
            afiliado.setDni("");
        }
        return afiliado;
    }

}
