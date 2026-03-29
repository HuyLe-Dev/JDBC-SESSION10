package com.example.exercise05;

public class Invoice {
    private String code;
    private double amount;

    public Invoice(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Code: %s, Amount: %.2f", code, amount);
    }
}
