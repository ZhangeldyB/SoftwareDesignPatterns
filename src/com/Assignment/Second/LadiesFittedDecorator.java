package com.Assignment.Second;

public class LadiesFittedDecorator extends ShirtDecorator{
    public LadiesFittedDecorator(Shirt s) {
        this.shirt = s;
    }

    @Override
    public String getDescription() {
        return shirt.getDescription() + ", ladies fitted";
    }

    @Override
    public int getPrice() {
        return shirt.getPrice() - 2;
    }
}
