package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.service.FacturaService;
import com.sistemas.facturacion.service.afipService.ServiceSoap;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl {//implements FacturaService {

//    @Override
    public static void generarFactura() {
        ServiceSoap serviceSoap = new com.sistemas.facturacion.service.afipService.Service().getServiceSoap();
        System.out.println(serviceSoap.feDummy());

    }

    public static void main(String[] args) throws Exception {
        generarFactura();
    }

}
