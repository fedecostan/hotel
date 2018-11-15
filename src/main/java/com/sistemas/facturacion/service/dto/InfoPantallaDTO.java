package com.sistemas.facturacion.service.dto;

import com.sistemas.facturacion.model.CondicionVenta;
import com.sistemas.facturacion.model.SituacionIva;
import com.sistemas.facturacion.model.TipoComprobante;

import java.util.List;

public class InfoPantallaDTO {

    private List<TipoComprobante> tipoComprobanteList;
    private List<SituacionIva> situacionIvaList;
    private List<CondicionVenta> condicionVentaList;

    public List<TipoComprobante> getTipoComprobanteList() {
        return tipoComprobanteList;
    }

    public void setTipoComprobanteList(List<TipoComprobante> tipoComprobanteList) {
        this.tipoComprobanteList = tipoComprobanteList;
    }

    public List<SituacionIva> getSituacionIvaList() {
        return situacionIvaList;
    }

    public void setSituacionIvaList(List<SituacionIva> situacionIvaList) {
        this.situacionIvaList = situacionIvaList;
    }

    public List<CondicionVenta> getCondicionVentaList() {
        return condicionVentaList;
    }

    public void setCondicionVentaList(List<CondicionVenta> condicionVentaList) {
        this.condicionVentaList = condicionVentaList;
    }
}
