package com.sipios.refactoring.model;

public class Customer {

    private Item[] items;
    private String customerType;

    public Customer(Item[] is, String customerType) {
        this.items = is;
        this.customerType = customerType;
    }

    public Customer() {}

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
