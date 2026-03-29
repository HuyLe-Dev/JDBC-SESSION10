package com.example.exercise06;

public class Order {
    // Encapsulation: Trạng thái (state) luôn private
    private String code;
    private String customerName;

    public Order(String code, String customerName) {
        this.code = code;
        this.customerName = customerName;
    }

    // Getters & Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return String.format("Mã đơn hàng: %s, Tên khách hàng: %s", code, customerName);
    }
}
