package com.sipios.refactoring.model;

public class Customer {

    private Item[] items;
    private String type;

    public Customer(Item[] is, String t) {
        this.items = is;
        this.type = t;
    }

    public Customer() {}

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
