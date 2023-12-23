package com.example.layeredarchitecture.model;

import java.time.LocalDate;

public class CustomDto {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String orderId;
    private LocalDate orderDate;

    public CustomDto(String customerId, String customerName, String customerAddress, String orderId, LocalDate orderDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public CustomDto() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
