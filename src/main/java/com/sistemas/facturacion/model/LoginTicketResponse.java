package com.sistemas.facturacion.model;

public class LoginTicketResponse {

    private Header header;
    private Credentials credentials;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
