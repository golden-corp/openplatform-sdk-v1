package com.golden.request;

import java.util.List;

public class InvoiceBlue {

    private String taxpayerNum;

    private String sellerAddress;

    private String sellerTel;

    private String sellerBankName;

    private String sellerBankAccount;

    private int buyerTitleType;

    private String orderId;

    private String bUserId;

    private String buyerTaxCode;

    private String buyerTitle;

    private String buyerBankName;

    private String buyerBankAccount;

    private String buyerPhone;

    private String buyerEmail;

    private String buyerAddress;

    private String extra;

    private String callbackUrl;

    private String cashier;

    private String checker;

    private String invoicer;

    private int tradeType;

    private String machineNo;

    private String etrData;

    private String invoiceTypeCode;

    private String specialInvoiceKind;

    private String terminalCode;

    private List<InvoiceBlueGoodsInfo> GoodsInfos;

    @ApiField(name="taxpayer_num")
    public String getTaxpayerNum() {
        return taxpayerNum;
    }

    public InvoiceBlue setTaxpayerNum(String taxpayerNum) {
        this.taxpayerNum = taxpayerNum;
        return this;
    }

    @ApiField(name="seller_address")
    public String getSellerAddress() {
        return sellerAddress;
    }

    public InvoiceBlue setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
        return this;
    }

    @ApiField(name="seller_tel")
    public String getSellerTel() {
        return sellerTel;
    }

    public InvoiceBlue setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
        return this;
    }

    @ApiField(name="seller_bank_name")
    public String getSellerBankName() {
        return sellerBankName;
    }

    public InvoiceBlue setSellerBankName(String sellerBankName) {
        this.sellerBankName = sellerBankName;
        return this;
    }

    @ApiField(name="seller_bank_account")
    public String getSellerBankAccount() {
        return sellerBankAccount;
    }

    public InvoiceBlue setSellerBankAccount(String sellerBankAccount) {
        this.sellerBankAccount = sellerBankAccount;
        return this;
    }

    @ApiField(name="buyer_title_type")
    public int getBuyerTitleType() {
        return buyerTitleType;
    }

    public InvoiceBlue setBuyerTitleType(int buyerTitleType) {
        this.buyerTitleType = buyerTitleType;
        return this;
    }

    @ApiField(name="order_id")
    public String getOrderId() {
        return orderId;
    }

    public InvoiceBlue setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    @ApiField(name="b_user_id")
    public String getbUserId() {
        return bUserId;
    }

    public InvoiceBlue setbUserId(String bUserId) {
        this.bUserId = bUserId;
        return this;
    }

    @ApiField(name="buyer_taxcode")
    public String getBuyerTaxCode() {
        return buyerTaxCode;
    }

    public InvoiceBlue setBuyerTaxCode(String buyerTaxCode) {
        this.buyerTaxCode = buyerTaxCode;
        return this;
    }

    @ApiField(name="buyer_title")
    public String getBuyerTitle() {
        return buyerTitle;
    }

    public InvoiceBlue setBuyerTitle(String buyerTitle) {
        this.buyerTitle = buyerTitle;
        return this;
    }

    @ApiField(name="buyer_bank_name")
    public String getBuyerBankName() {
        return buyerBankName;
    }

    public InvoiceBlue setBuyerBankName(String buyerBankName) {
        this.buyerBankName = buyerBankName;
        return this;
    }

    @ApiField(name="buyer_bank_account")
    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    public InvoiceBlue setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount;
        return this;
    }

    @ApiField(name="buyer_phone")
    public String getBuyerPhone() {
        return buyerPhone;
    }

    public InvoiceBlue setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
        return this;
    }

    @ApiField(name="buyer_email")
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public InvoiceBlue setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
        return this;
    }

    @ApiField(name="buyer_address")
    public String getBuyerAddress() {
        return buyerAddress;
    }

    public InvoiceBlue setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
        return this;
    }

    @ApiField(name="extra")
    public String getExtra() {
        return extra;
    }

    public InvoiceBlue setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    @ApiField(name="callback_url")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    public InvoiceBlue setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    @ApiField(name="cashier")
    public String getCashier() {
        return cashier;
    }

    public InvoiceBlue setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }

    @ApiField(name="checker")
    public String getChecker() {
        return checker;
    }

    public InvoiceBlue setChecker(String checker) {
        this.checker = checker;
        return this;
    }

    @ApiField(name="invoicer")
    public String getInvoicer() {
        return invoicer;
    }

    public InvoiceBlue setInvoicer(String invoicer) {
        this.invoicer = invoicer;
        return this;
    }

    @ApiField(name="trade_type")
    public int getTradeType() {
        return tradeType;
    }

    public InvoiceBlue setTradeType(int tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    @ApiField(name="machine_no")
    public String getMachineNo() {
        return machineNo;
    }

    public InvoiceBlue setMachineNo(String machineNo) {
        this.machineNo = machineNo;
        return this;
    }

    @ApiField(name="etr_data")
    public String getEtrData() {
        return etrData;
    }

    public InvoiceBlue setEtrData(String etrData) {
        this.etrData = etrData;
        return this;
    }

    @ApiField(name="invoice_type_code")
    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public InvoiceBlue setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
        return this;
    }

    @ApiField(name="invoice_kind")
    public String getSpecialInvoiceKind() {
        return specialInvoiceKind;
    }

    public InvoiceBlue setSpecialInvoiceKind(String specialInvoiceKind) {
        this.specialInvoiceKind = specialInvoiceKind;
        return this;
    }

    @ApiField(name="terminal_code")
    public String getTerminalCode() {
        return terminalCode;
    }

    public InvoiceBlue setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
        return this;
    }

    @ApiField(name="goods_info")
    public List<InvoiceBlueGoodsInfo> getGoodsInfos() {
        return GoodsInfos;
    }

    public InvoiceBlue setGoodsInfos(List<InvoiceBlueGoodsInfo> goodsInfos) {
        GoodsInfos = goodsInfos;
        return this;
    }
}
