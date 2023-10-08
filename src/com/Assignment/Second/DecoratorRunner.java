package com.Assignment.Second;

public class DecoratorRunner {
    public static void main(String[] args) {
        Shirt first = new BasicShirt("Shirt", 10);
        first = new LongSleeveDecorator(first);
        System.out.println(first.getPrice());
        System.out.println(first.getDescription());
        System.out.println();
        Shirt second = new BasicShirt("T-shirt", 8);
        second = new VneckedDecorator(second);
        second = new LadiesFittedDecorator(second);
        System.out.println(second.getDescription());
        System.out.println(second.getPrice());
    }
}
