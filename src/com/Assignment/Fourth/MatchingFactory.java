package com.Assignment.Fourth;

public class MatchingFactory implements IContentFactory{
    @Override
    public IContent createContent() {
        return new Matching();
    }
}
