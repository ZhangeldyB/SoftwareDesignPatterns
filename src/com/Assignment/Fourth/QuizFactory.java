package com.Assignment.Fourth;

public class QuizFactory implements IContentFactory{
    @Override
    public IContent createContent() {
        return new Quiz();
    }
}
