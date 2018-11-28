
package com.sistemas.facturacion.service.afipService.wsaa;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "fault", targetNamespace = "https://wsaa.afip.gov.ar/ws/services/LoginCms")
public class LoginFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private LoginFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public LoginFault_Exception(String message, LoginFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public LoginFault_Exception(String message, LoginFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: https.wsaa_afip_gov_ar.ws.services.logincms.LoginFault
     */
    public LoginFault getFaultInfo() {
        return faultInfo;
    }

}