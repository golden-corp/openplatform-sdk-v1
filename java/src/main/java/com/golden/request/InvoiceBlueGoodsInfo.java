package com.golden.request;

public class InvoiceBlueGoodsInfo {

    private String name;

    private String taxCode;

    private String taxType;

    private String models;

    private String unit;

    private String totalPrice;

    private String total;

    private String price;

    private String taxRate;

    private String taxAmount;

    private String zeroTaxFlag;

    @ApiField(name="name")
    public String getName() {
        return name;
    }

    public InvoiceBlueGoodsInfo setName(String name) {
        this.name = name;
        return this;
    }

    @ApiField(name="tax_code")
    public String getTaxCode() {
        return taxCode;
    }

    public InvoiceBlueGoodsInfo setTaxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    @ApiField(name="tax_type")
    public String getTaxType() {
        return taxType;
    }

    public InvoiceBlueGoodsInfo setTaxType(String taxType) {
        this.taxType = taxType;
        return this;
    }

    @ApiField(name="models")
    public String getModels() {
        return models;
    }

    public InvoiceBlueGoodsInfo setModels(String models) {
        this.models = models;
        return this;
    }

    @ApiField(name="unit")
    public String getUnit() {
        return unit;
    }

    public InvoiceBlueGoodsInfo setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @ApiField(name="total_price")
    public String getTotalPrice() {
        return totalPrice;
    }

    public InvoiceBlueGoodsInfo setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @ApiField(name="total")
    public String getTotal() {
        return total;
    }

    public InvoiceBlueGoodsInfo setTotal(String total) {
        this.total = total;
        return this;
    }

    @ApiField(name="price")
    public String getPrice() {
        return price;
    }

    public InvoiceBlueGoodsInfo setPrice(String price) {
        this.price = price;
        return this;
    }

    @ApiField(name="tax_rate")
    public String getTaxRate() {
        return taxRate;
    }

    public InvoiceBlueGoodsInfo setTaxRate(String taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    @ApiField(name="tax_amount")
    public String getTaxAmount() {
        return taxAmount;
    }

    public InvoiceBlueGoodsInfo setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    @ApiField(name="zero_tax_flag")
    public String getZeroTaxFlag() {
        return zeroTaxFlag;
    }

    public InvoiceBlueGoodsInfo setZeroTaxFlag(String zeroTaxFlag) {
        this.zeroTaxFlag = zeroTaxFlag;
        return this;
    }
}
