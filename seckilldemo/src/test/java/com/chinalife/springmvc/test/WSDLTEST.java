package com.chinalife.springmvc.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chinalife on 2017/11/6.
 */
public class WSDLTEST {
    public synchronized static String accessService(String wsdl, String ns, String method, Map<String,String> params, String result)throws Exception{
        //拼接参数
        String param = getParam(params);
        String soapResponseData = "";
        //拼接SOAP
        StringBuffer soapRequestData = new StringBuffer("");
        soapRequestData.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        soapRequestData.append("<soap:Body>");
        soapRequestData.append("<ns1:"+method+" xmlns:ns1=\""+ns+"\">");
        soapRequestData.append(param);
        soapRequestData.append("</ns1:"+method+">");
        soapRequestData.append("</soap:Body>" + "</soap:Envelope>");
        PostMethod postMethod = new PostMethod(wsdl);
        // 然后把Soap请求数据添加到PostMethod中
        byte[] b=null;
        InputStream is=null;
        try {
            b = soapRequestData.toString().getBytes("utf-8");
            is = new ByteArrayInputStream(b, 0, b.length);
            RequestEntity re = new InputStreamRequestEntity(is, b.length,"text/xml; charset=UTF-8");
            postMethod.setRequestEntity(re);
            HttpClient httpClient = new HttpClient();
            int status = httpClient.executeMethod(postMethod);
            System.out.println("status:"+status);
            if(status==200){
                soapResponseData = getMesage(postMethod.getResponseBodyAsString(),result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(is!=null){
                is.close();
            }
        }
        return soapResponseData;
    }

    public static String getParam(Map<String,String> params){
        String param = "";
        if(params!=null){
            Iterator<String> it  = params.keySet().iterator();
            while(it.hasNext()){
                String str = it.next();
                param+="<"+str+">";
                param+=params.get(str);
                param+="</"+str+">";
            }
        }
        return param;
    }

    public static String getMesage(String soapAttachment,String result){
        System.out.println("message:"+soapAttachment);
        if(result==null){
            return null;
        }
        if(soapAttachment!=null && soapAttachment.length()>0){
            int begin = soapAttachment.indexOf(result);
            begin = soapAttachment.indexOf(">", begin);
            int end = soapAttachment.indexOf("</"+result+">");
            String str = soapAttachment.substring(begin+1, end);
            str = str.replaceAll("<", "<");
            str = str.replaceAll(">", ">");
            return str;
        }else{
            return "";
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Map<String,String> param = new HashMap<String,String>();
            param.put("arg0", "sun");
            String wsdl="http://localhost:8080/WebService/WebServicePort?wsdl";
            String ns = "http://webservice.com/";
            String method="printData";
            String response =accessService(wsdl,ns,method,param,"return");
            System.out.println("main:"+response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

