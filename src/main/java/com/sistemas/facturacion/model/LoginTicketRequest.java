package com.sistemas.facturacion.model;

public class LoginTicketRequest {

    private Header header;
    private Service service;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
