package com.golden.request;

public class InvoiceRedInvoice {

    private String  taxpayerNum;

    private String bTradeNo;

    private String gTradeNo;


    @ApiField(name="taxpayer_num")
    public String getTaxpayerNum() {
        return taxpayerNum;
    }

    public InvoiceRedInvoice setTaxpayerNum(String taxpayerNum) {
        this.taxpayerNum = taxpayerNum;
        return this;
    }

    @ApiField(name="b_trade_no")
    public String getbTradeNo() {
        return bTradeNo;
    }

    public InvoiceRedInvoice setbTradeNo(String bTradeNo) {
        this.bTradeNo = bTradeNo;
        return this;
    }

    @ApiField(name="g_trade_no")
    public String getgTradeNo() {
        return gTradeNo;
    }

    public InvoiceRedInvoice setgTradeNo(String gTradeNo) {
        this.gTradeNo = gTradeNo;
        return this;
    }
}
