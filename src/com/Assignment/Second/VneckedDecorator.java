package com.Assignment.Second;

public class VneckedDecorator extends ShirtDecorator{

    public VneckedDecorator(Shirt s) {
        this.shirt = s;
    }

    @Override
    public String getDescription() {
        return shirt.getDescription() + ", v-necked";
    }

    @Override
    public int getPrice() {
        return shirt.getPrice() + 1;
    }
}
