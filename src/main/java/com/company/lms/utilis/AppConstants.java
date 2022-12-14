package com.company.lms.utilis;

public class AppConstants {
     public final static String KYC_REQUEST ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cus=\"http://credable.io/cbs/customer\">\n" +
            "   <soapenv:Header>\n" +
            "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" wsse:mustUnderstand=\"1\">\n" +
            "  <wsse:UsernameToken>\n" +
            "     <wsse:Username>%s</wsse:Username>\n" +
            "     <wsse:Password>%s</wsse:Password>\n" +
            "  </wsse:UsernameToken>\n" +
            "</wsse:Security>\n" +
            "   </soapenv:Header>\n" +
            "   <soapenv:Body>\n" +
            "      <cus:CustomerRequest>\n" +
            "         <cus:customerNumber>%s</cus:customerNumber>\n" +
            "      </cus:CustomerRequest>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
     public final  static String KYC_URL="https://kycapitest.credable.io/service/customerWsdl.wsdl";
     public final  static String TRANSACTIONS_URL="https://trxapitest.credable.io/service/transactionWsdl.wsdl";
     public final static String TRANSACTIONS_REQ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://credable.io/cbs/transaction\">\n" +
             "     <soapenv:Header>\n" +
             "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" wsse:mustUnderstand=\"1\">\n" +
             "  <wsse:UsernameToken>\n" +
             "     <wsse:Username>%s</wsse:Username>\n" +
             "     <wsse:Password>%s</wsse:Password>\n" +
             "  </wsse:UsernameToken>\n" +
             "</wsse:Security>\n" +
             "   </soapenv:Header>\n" +
             "   <soapenv:Body>\n" +
             "      <tran:TransactionsRequest>\n" +
             "         <tran:customerNumber>%s</tran:customerNumber>\n" +
             "      </tran:TransactionsRequest>\n" +
             "   </soapenv:Body>\n" +
             "</soapenv:Envelope>";
     public final static String SCORE_INIT_URL="https://scoringtest.credable.io/api/v1/scoring/initiateQueryScore/%s";
     public final static String SCORE_URL="https://scoringtest.credable.io/api/v1/scoring/queryScore/%s";
     public final static  String CLIENT_URL ="https://scoringtest.credable.io/api/v1/client/createClient";
     public final static  String LMS_TRANSACTIONS_URL ="https://lms-java-app.herokuapp.com/transactions/%s";

}
