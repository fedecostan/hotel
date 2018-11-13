package com.sistemas.facturacion.service.dto;

import com.sistemas.facturacion.model.Sindicato;
import com.sistemas.facturacion.model.TipoComprobante;

import java.util.List;

public class InfoPantallaDTO {

    private List<TipoComprobante> tipoComprobanteList;

    public List<TipoComprobante> getTipoComprobanteList() {
        return tipoComprobanteList;
    }

    public void setTipoComprobanteList(List<TipoComprobante> tipoComprobanteList) {
        this.tipoComprobanteList = tipoComprobanteList;
    }

}
