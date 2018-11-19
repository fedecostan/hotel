package com.sistemas.facturacion.service.dto;

import java.util.List;

public class InfoPantallaDTO {

    private List<TipoComprobanteDTO> tipoComprobanteDTOList;
    private List<SituacionesIVADTO> situacionesIVADTOList;
    private List<CondicionVentaDTO> condicionVentaDTOList;

    public List<TipoComprobanteDTO> getTipoComprobanteDTOList() {
        return tipoComprobanteDTOList;
    }

    public void setTipoComprobanteDTOList(List<TipoComprobanteDTO> tipoComprobanteDTOList) {
        this.tipoComprobanteDTOList = tipoComprobanteDTOList;
    }

    public List<SituacionesIVADTO> getSituacionesIVADTOList() {
        return situacionesIVADTOList;
    }

    public void setSituacionesIVADTOList(List<SituacionesIVADTO> situacionesIVADTOList) {
        this.situacionesIVADTOList = situacionesIVADTOList;
    }

    public List<CondicionVentaDTO> getCondicionVentaDTOList() {
        return condicionVentaDTOList;
    }

    public void setCondicionVentaDTOList(List<CondicionVentaDTO> condicionVentaDTOList) {
        this.condicionVentaDTOList = condicionVentaDTOList;
    }
}
