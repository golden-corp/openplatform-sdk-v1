使用方法
===============================
支持JDK >= 1.7

[下载jar包](https://upload.wetax.com.cn/SDK_Packets/20200111120900.zip)

导入jar包

- 通用不具名接口

```java
package examples;

import com.golden.Sdk;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class example {

    public static void main(String []args){

        Sdk sdk = new Sdk("testappkey111", "testappsecret", "test");
		  sdk.setBaseUrl("http://182.254.219.106:8400");//可行自行设置服务器地址
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
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
```

- 快速开具蓝票

```java
package examples;

import com.golden.Sdk;
import com.golden.request.InvoiceBlue;
import com.golden.request.InvoiceBlueGoodsInfo;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class exampleInvoiceBlue {

    public static void main(String[] args ){
        Sdk sdk = new Sdk("testappkey111", "testappsecret", "test");
        InvoiceBlue invoice = new InvoiceBlue();
        List<InvoiceBlueGoodsInfo> goodsInfos = new ArrayList<>();
        InvoiceBlueGoodsInfo goodsInfo = new InvoiceBlueGoodsInfo();
        goodsInfo.setName("打火机")
                .setPrice("1.00")
                .setTaxAmount("0.06")
                .setTaxRate("0.06")
                .setTaxCode("1020202000000000000")
                .setTotal("1")
                .setTotalPrice("1.00")
                .setUnit("个");
        goodsInfos.add(goodsInfo);

        goodsInfo = new InvoiceBlueGoodsInfo();
        goodsInfo.setName("矿泉水")
                .setPrice("2.00")
                .setTaxAmount("0.12")
                .setTaxRate("0.06")
                .setTaxCode("1020202000000002222")
                .setTotal("1")
                .setTotalPrice("2.00")
                .setUnit("瓶");
        goodsInfos.add(goodsInfo);

        invoice.setBuyerTitleType(1)
                .setTaxpayerNum("91469027MA5RH09M0R")
                .setOrderId("ssssss121")
                .setBuyerTitle("小明")
                .setBuyerAddress("广东省深圳市xx街道xx号")
                .setBuyerPhone("1333333333")
                .setBuyerBankAccount("123213232323232324234234")
                .setBuyerBankName("中国工商银行")
                .setExtra("发票备注")
                .setCashier("张某某")
                .setChecker("李某某")
                .setInvoicer("邓花花")
                .setTradeType(3)
                .setCallbackUrl("http://test.feehi.com/sign/mock/callback.php")
                .setGoodsInfos(goodsInfos);
        try {
            JSONObject result = sdk.invoiceBlue(invoice);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
```

- 快速开具红票

```java
package examples;

import com.golden.Sdk;
import com.golden.request.InvoiceRed;
import com.golden.request.InvoiceRedInvoice;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class exampleInvoiceRed {

    public static void main(String[] args){
        Sdk sdk = new Sdk("testappkey111", "testappsecret", "test");
        InvoiceRed invoiceRed = new InvoiceRed();
        List<InvoiceRedInvoice> invoices = new ArrayList<>();
        InvoiceRedInvoice invoice = new InvoiceRedInvoice();
        invoice.setTaxpayerNum("91469027MA5RH09M0R")
                .setgTradeNo("11111111111111111111111111111111")
                .setbTradeNo("2222222222222222222222222222222");
        invoices.add(invoice);

        invoiceRed.setCallbackUrl("http://www.xxx.com/callback")
                .setInvoices(invoices);
        try {
            JSONObject result = sdk.invoiceRed(invoiceRed);
            System.out.println(result);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
```
运行examples
============
- 通用不具名接口
```bash
    java -jar sdk.jar
```

- 快速开具蓝票
```bash
    java -cp sdk.jar examples.exampleInvoiceBlue
```

- 快速开具红票
```bash
    java -cp sdk.jar examples.exampleInvoiceRed
```