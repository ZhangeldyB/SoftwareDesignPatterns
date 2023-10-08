package com.Assignment.Second;

public class DropTailDecorator extends ShirtDecorator{
    public DropTailDecorator(Shirt s) {
        this.shirt = s;
    }

    @Override
    public String getDescription() {
        return shirt.getDescription() + ", droptailed";
    }

    @Override
    public int getPrice() {
        return shirt.getPrice() + 1;
    }
}
