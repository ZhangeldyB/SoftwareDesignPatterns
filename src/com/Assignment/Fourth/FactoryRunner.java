package com.Assignment.Fourth;

import java.util.Scanner;

public class FactoryRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();
        IContentFactory contentFactory = null;
        IContent content = null;

        switch (userChoice) {
            case "Quiz" -> contentFactory = new QuizFactory();
            case "Flashcard" -> contentFactory = new FlashCardFactory();
            case "Matching" -> contentFactory = new MatchingFactory();
            case "Open ended questions" -> contentFactory = new OpenEndedQuestionsFactory();
        }
        assert contentFactory != null;
        content = contentFactory.createContent();
        content.display();
    }
}
