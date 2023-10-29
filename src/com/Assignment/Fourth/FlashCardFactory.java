package com.Assignment.Fourth;

public class FlashCardFactory implements IContentFactory{
    @Override
    public IContent createContent() {
        return new FlashCard();
    }
}
