package examples;

import com.golden.Sdk;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class example {

    public static void main(String []args){

        Sdk sdk = new Sdk("testappkey111", "testappsecret", "test");
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("aaa", "~");
            jsonObject.put("buyer_title", "高灯");
            jsonObject.put("family", "fff@dd.c*+ om");//示例，可以忽略
            JSONObject detail = new JSONObject();//示例，可以忽略
            detail.put("name", "sss");//示例，可以忽略
            detail.put("sdfsdfsdf", "sss");//示例，可以忽略
            jsonObject.put("ss", detail);//示例，可以忽略
            JSONObject result = sdk.httpPost("/merchant/search", jsonObject);
            System.out.println(result);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
