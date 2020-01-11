package com.golden;

import com.golden.request.*;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sdk {

    public static final String EQUAL = "=";
    public static final String AND = "&";

    private String env;
    private String appkey;
    private String appsecret;
    private String baseUrl;

    public Sdk(String appkey, String appSecret, String env)
    {
        this.env = env;
        this.appkey = appkey;
        this.appsecret = appSecret;
    }


    public String genereateSign(JSONObject json, Long timestamp) throws UnsupportedEncodingException
    {
        Iterator<String> it = json.keys();

        ArrayList<String> arrayList = new ArrayList<String>();
        while (it.hasNext()){
            String key = it .next();
            arrayList.add(key);
        }

        Collections.sort(arrayList);

        StringBuilder originStringBuilder = new StringBuilder();
        originStringBuilder.append(this.appkey);
        originStringBuilder.append(timestamp);

        StringBuilder postStringBuilder = new StringBuilder();
        for(int i=0; i < arrayList.size(); i++){
            String key = arrayList.get(i);
            Object value = json.get(key);
            postStringBuilder.append( key + EQUAL + value.toString() + AND );
        }
        postStringBuilder.deleteCharAt(postStringBuilder.length() - 1);

        String postString = URLEncoder.encode(postStringBuilder.toString(), "utf-8").replace("*", "%2A").replace("+", "%20").replace("%7E", "~");

        String originStr = originStringBuilder.toString() + postString + this.appsecret;
        //System.out.println(originStr);

       return Util.md5(originStr).toUpperCase();
    }

    public String getEnv() {
        return env;
    }

    public Sdk setEnv(String env){
        this.env = env;
        return this;
    }
    
    public void setBaseUrl(String url) {
    	this.baseUrl = url; 
    }

    public String getBaseUrl() {
    	if(this.baseUrl!=null) {
    		return this.baseUrl;
    	}
    	if( this.env.equals("test" )){
    		return  EnvEnum.URL.TEST.getUrl();
        }else{
        	return  EnvEnum.URL.PROD.getUrl();
        }
    }
    
    public JSONObject httpPost(String url, JSONObject json) throws RuntimeException,IOException
    {
        Long timestamp = System.currentTimeMillis() / 1000;
        String sign = genereateSign(json, timestamp);
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        String requestUrl = this.getBaseUrl();
        requestUrl += url + "?signature=" + sign + "&appkey=" + this.appkey + "&timestamp=" + timestamp;
        //System.out.println(requestUrl);
        HttpPost post = new HttpPost(requestUrl);
        JSONObject response = null;//System.out.println(json.toString());
        StringEntity s = new StringEntity(json.toString(), "utf-8");
        //System.out.println(json.toString());
        s.setContentEncoding("utf-8");
        s.setContentType("application/json");
        post.setEntity(s);
        HttpResponse res = httpclient.execute(post);
        if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String result = EntityUtils.toString(res.getEntity(), "utf-8");
            response = JSONObject.fromObject(result);
        }
        return response;
    }

    public JSONObject invoiceBlue(InvoiceBlue invoiceBlue) throws RuntimeException,IOException,IllegalAccessException, InvocationTargetException
    {
        JSONObject postData = new JSONObject();
        Method[] methods = InvoiceBlue.class.getMethods();
        for (Method method : methods) {
            ApiField field = method.getAnnotation(ApiField.class);
            if( field == null || field.name() == "goods_info" ) continue;
            postData.put( field.name(), method.invoke(invoiceBlue, null));
        }

        List<InvoiceBlueGoodsInfo> invoiceBlueGoodsInfo = invoiceBlue.getGoodsInfos();
        JSONObject[] goodsInfos = new JSONObject[invoiceBlueGoodsInfo.size()];
        for(int i=0; i<invoiceBlueGoodsInfo.size(); i++){
            JSONObject goodsInfo = new JSONObject();
            methods = InvoiceBlueGoodsInfo.class.getMethods();
            for (Method method : methods) {
                ApiField field = method.getAnnotation(ApiField.class);
                if( field == null ) continue;
                goodsInfo.put( field.name(), method.invoke(invoiceBlueGoodsInfo.get(i), null));
            }
            goodsInfos[i] = goodsInfo;
        }

        postData.put("goods_info", goodsInfos);
        return this.httpPost("/invoice/blue", postData);
    }

    public JSONObject invoiceRed(InvoiceRed invoiceRed) throws RuntimeException,IOException,IllegalAccessException, InvocationTargetException
    {
        JSONObject postData = new JSONObject();
        Method[] methods = InvoiceRed.class.getMethods();
        for (Method method : methods) {
            ApiField field = method.getAnnotation(ApiField.class);
            if( field == null || field.name() == "invoice" ) continue;
            postData.put( field.name(), method.invoke(invoiceRed, null));
        }

        List<InvoiceRedInvoice> invoiceRedInvoices = invoiceRed.getInvoices();
        JSONObject[] invoices = new JSONObject[invoiceRedInvoices.size()];
        for(int i=0; i<invoiceRedInvoices.size(); i++){
            JSONObject invoice = new JSONObject();
            methods = InvoiceRedInvoice.class.getMethods();
            for (Method method : methods) {
                ApiField field = method.getAnnotation(ApiField.class);
                if( field == null ) continue;
                invoice.put( field.name(), method.invoke(invoiceRedInvoices.get(i), null));
            }
            invoices[i] = invoice;
        }

        postData.put("invoice", invoices);
        return this.httpPost("/invoice/red", postData);
    }

}
