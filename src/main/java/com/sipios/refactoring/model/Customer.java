package com.sipios.refactoring.model;

import com.sipios.refactoring.enums.CustomerType;

public class Customer {

    private Item[] items;
    private CustomerType customerType;

    public Customer(Item[] is, CustomerType customerType) {
        this.items = is;
        this.customerType = customerType;
    }

    public Customer() {
        this.customerType = CustomerType.STANDARD_CUSTOMER;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
