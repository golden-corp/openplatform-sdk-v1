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
