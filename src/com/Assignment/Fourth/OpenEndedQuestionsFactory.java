package com.Assignment.Fourth;

public class OpenEndedQuestionsFactory implements IContentFactory{
    @Override
    public IContent createContent() {
        return new OpenEndedQuestions();
    }
}
