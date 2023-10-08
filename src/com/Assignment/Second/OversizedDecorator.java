package com.Assignment.Second;

public class OversizedDecorator extends ShirtDecorator{

    public OversizedDecorator(Shirt s) {
        this.shirt = s;
    }

    @Override
    public String getDescription() {
        return shirt.getDescription() + ", oversize";
    }

    @Override
    public int getPrice() {
        return shirt.getPrice() + 3;
    }
}
