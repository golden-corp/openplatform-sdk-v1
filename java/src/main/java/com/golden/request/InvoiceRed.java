package com.golden.request;

import java.util.List;

public class InvoiceRed {

    private String callbackUrl;

    private List<InvoiceRedInvoice> invoices;


    @ApiField(name="callback_url")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    public InvoiceRed setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    @ApiField(name="invoice")
    public List<InvoiceRedInvoice> getInvoices() {
        return invoices;
    }

    public InvoiceRed setInvoices(List<InvoiceRedInvoice> invoice) {
        this.invoices = invoice;
        return this;
    }
}
