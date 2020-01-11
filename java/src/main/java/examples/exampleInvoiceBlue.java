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
                .setTaxpayerNum("911101076819664431")
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
