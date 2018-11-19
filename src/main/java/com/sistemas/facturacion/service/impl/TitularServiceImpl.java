package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.model.Titular;
import com.sistemas.facturacion.repository.DelegacionRepository;
import com.sistemas.facturacion.repository.TitularRepository;
import com.sistemas.facturacion.service.TitularService;
import com.sistemas.facturacion.service.dto.TitularDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitularServiceImpl implements TitularService {

    @Autowired
    private TitularRepository titularRepository;

    @Autowired
    private DelegacionRepository delegacionRepository;

    @Override
    public List<TitularDTO> obtenerTodos() {
        List<Titular> titularList = titularRepository.findAll();
        List<TitularDTO> titularDTOList = new ArrayList<>();
        for (Titular titular : titularList){
            TitularDTO titularDTO = new TitularDTO();
            titularDTO.setValue(titular.getNumeroRegistro());
            titularDTO.setName(titular.getApellidoYNombre());
            titularDTO.setSindicato(titular.getTitularAList().get(titular.getTitularAList().size()-1).getDelegacion());
            titularDTO.setIoma(titular.getIoma());
            titularDTO.setBarra(titular.getBarra());
            titularDTO.setFamilia(titular.getCodigoFamilia());
            titularDTO.setDni(titular.getNumeroDocumento());
            titularDTO.setBloqueado(titular.getBloqueado());
            titularDTO.setFechaBaja("REVISAR");
            titularDTOList.add(titularDTO);
        }
        return titularDTOList;
    }

    @Override
    public List<TitularDTO> obtenerPorSindicato(String sindicato) {
        List<Titular> titularList = titularRepository.findBySindicato(sindicato);
        List<TitularDTO> titularDTOList = new ArrayList<>();
        for (Titular titular : titularList){
            TitularDTO titularDTO = new TitularDTO();
            titularDTO.setValue(titular.getNumeroRegistro());
            titularDTO.setName(titular.getApellidoYNombre());
            titularDTO.setSindicato(titular.getTitularAList().get(titular.getTitularAList().size()-1).getDelegacion());
            titularDTO.setIoma(titular.getIoma());
            titularDTO.setBarra(titular.getBarra());
            titularDTO.setFamilia(titular.getCodigoFamilia());
            titularDTO.setDni(titular.getNumeroDocumento());
            titularDTO.setBloqueado(titular.getBloqueado());
            titularDTO.setFechaBaja("REVISAR");
            titularDTOList.add(titularDTO);
        }
        return titularDTOList;
    }

    @Override
    public TitularDTO obtenerPorId(Long id) {
        String formattedNumber = String.format("%011d", id);
        Titular titular = titularRepository.findByNumeroRegistro(formattedNumber);
        TitularDTO titularDTO = new TitularDTO();
        if (titular != null){
            titularDTO.setValue(titular.getNumeroRegistro());
            titularDTO.setName(titular.getApellidoYNombre());
            titularDTO.setSindicato(titular.getTitularAList().get(titular.getTitularAList().size()-1).getDelegacion());
            titularDTO.setIoma(titular.getIoma());
            titularDTO.setBarra(titular.getBarra());
            titularDTO.setFamilia(titular.getCodigoFamilia());
            titularDTO.setDni(titular.getNumeroDocumento());
            titularDTO.setBloqueado(titular.getBloqueado());
            titularDTO.setFechaBaja("REVISAR");
        } else {
            titularDTO.setName("N/A");
        }
        return titularDTO;
    }

    @Override
    public TitularDTO obtenerPorIdYSindicato(Long id, Long sindicato) {
        String formattedTitular = String.format("%011d", id);
        String formattedSindicato = String.format("%03d", sindicato);
        Titular titular = titularRepository.findByNumeroRegistroAndSindicato(formattedTitular, formattedSindicato);
        TitularDTO titularDTO = new TitularDTO();
        if (titular != null) {
            titularDTO.setValue(titular.getNumeroRegistro());
            titularDTO.setName(titular.getApellidoYNombre());
            titularDTO.setSindicato(titular.getTitularAList().get(titular.getTitularAList().size() - 1).getDelegacion());
            titularDTO.setIoma(titular.getIoma());
            titularDTO.setBarra(titular.getBarra());
            titularDTO.setFamilia(titular.getCodigoFamilia());
            titularDTO.setDni(titular.getNumeroDocumento());
            titularDTO.setBloqueado(titular.getBloqueado());
            titularDTO.setFechaBaja("REVISAR");
        } else {
            titularDTO.setName("N/A");
        }
        return titularDTO;
    }

}