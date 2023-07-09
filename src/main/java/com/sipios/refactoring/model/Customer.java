package com.sipios.refactoring.model;

import java.util.List;

import com.sipios.refactoring.enums.CustomerType;

public class Customer {

    private Cart cart;
    private CustomerType customerType;

    public Customer(Cart cart, CustomerType customerType) {
        this.cart = cart;
        this.customerType = customerType;
    }

    public Customer() {
        this.cart = new Cart();
        this.customerType = CustomerType.STANDARD_CUSTOMER;
    }

    public List<Item> getCartItems() {
        return cart.getItems();
    }

    public void setItems(List<Item> items) {
        this.cart.setItems(items);
    }

    public void addCartItem(Item item) {
        this.cart.addItem(item);
    }

    public void removeCartItem(Item item) {
        this.cart.removeItem(item);
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
