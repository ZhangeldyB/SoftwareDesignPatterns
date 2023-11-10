package com.ZhandySound.Factory.Factories;

import com.ZhandySound.Factory.Contents.AudioBook;
import com.ZhandySound.Factory.Factory;
import com.ZhandySound.Factory.IContent;

import java.util.List;

public class AudioBookFactory extends Factory {
    private List<String> chapters;
    @Override
    public IContent createContent(String authorName) {
        System.out.println("Enter the name of the audiobook:");
        name = sc.nextLine();
        System.out.println("Enter the number of chapters");
        for (int i = 1; i <= sc.nextInt(); i++) {
            System.out.printf("Enter a name of a chapter №%d \n", i);
            chapters.add(sc.nextLine());
        }
        return new AudioBook(name, authorName, chapters);
    }
}
