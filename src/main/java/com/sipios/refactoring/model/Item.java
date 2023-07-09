package com.sipios.refactoring.model;

public class Item {

    private String name;
    private int nb;

    public Item() {}

    public Item(String type, int quantity) {
        this.name = type;
        this.nb = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}