package com.Assignment.Second;

public class LongSleeveDecorator extends ShirtDecorator{

    public LongSleeveDecorator(Shirt s) {
        this.shirt = s;
    }

    @Override
    public String getDescription() {
        return shirt.getDescription() + ", long sleeved";
    }

    @Override
    public int getPrice() {
        return shirt.getPrice() + 2;
    }
}
