package com.sistemas.facturacion.service.impl;

import com.sistemas.facturacion.service.afipService.ServiceSoap;
import com.sistemas.facturacion.service.afipService.wsaa.LoginCMS;
import com.sistemas.facturacion.service.afipService.wsaa.LoginCMSService;
import com.sistemas.facturacion.service.afipService.wsaa.LoginFault_Exception;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.springframework.stereotype.Service;
import sun.security.rsa.RSASignature;
import sun.security.util.ObjectIdentifier;

import java.io.IOException;
import java.security.InvalidKeyException;

@Service
public class FacturaServiceImpl {//implements FacturaService {

//    @Override
    public static void generarFactura() {
        ServiceSoap serviceSoap = new com.sistemas.facturacion.service.afipService.Service().getServiceSoap();
        System.out.println(serviceSoap.feDummy());

    }

    public static void main(String[] args) throws Exception {
//        generarFactura();
        testwsaa();
    }

    private static void testwsaa() throws LoginFault_Exception, IOException, InvalidKeyException {
        String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<loginTicketRequest version=\"1.0\">\n" +
                "  <header>\n" +
                "    <source>cn=srv1,ou=facturacion,o=empresa s.a.,c=ar,serialNumber=CUIT 30123456789</source>\n" +
                "    <destination>cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 30123456789</destination>\n" +
                "    <uniqueId>4325399</uniqueId>\n" +
                "    <generationTime>2018-11-28T11:10:00-03:00</generationTime>\n" +
                "    <expirationTime>2018-11-28T11:20:00-03:00</expirationTime>\n" +
                "  </header>\n" +
                "  <service>wsfe</service>\n" +
                "</loginTicketRequest>";
        String bytesEncoded = Base64.encodeBase64String(msg.getBytes());

        ASN1Sequence asn1Sequence = (ASN1Sequence) ASN1Sequence.fromByteArray(msg.getBytes());
        ContentInfo contentInfo = ContentInfo.getInstance(asn1Sequence);
        DERSequence derSequence = (DERSequence) contentInfo.getContent();
        SignedData signedData = SignedData.getInstance(derSequence);

//        String bytes = RSASignature.SHA1withRSA.encodeSignature(new ObjectIdentifier(), msg.getBytes());


        LoginCMS loginCMS = new LoginCMSService().getLoginCms();
        System.out.println(loginCMS.loginCms(bytesEncoded));
    }

}
