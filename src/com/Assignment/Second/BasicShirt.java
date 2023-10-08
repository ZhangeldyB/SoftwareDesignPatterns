package com.Assignment.Second;

public class BasicShirt extends Shirt{

    public BasicShirt(String description, int price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
