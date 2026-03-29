package com.example.exercise05;

import java.util.ArrayList;
import java.util.List;

public class InvoiceManager implements IManage<Invoice> {
    private final List<Invoice> invoices = new ArrayList<>();

    @Override
    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public void update(int index, Invoice invoice) {
        if (isValidIndex(index)) {
            invoices.set(index, invoice);
        }
    }

    @Override
    public void delete(int index) {
        if (isValidIndex(index)) {
            invoices.remove(index);
        }
    }

    @Override
    public void display() {
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < invoices.size();
    }

    public int getSize() {
        return invoices.size();
    }
}
