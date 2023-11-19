package com.ZhandySound.Factory.Factories;

import com.ZhandySound.Factory.Contents.AudioBook;
import com.ZhandySound.Factory.Factory;
import com.ZhandySound.Factory.IContent;

import java.util.ArrayList;
import java.util.List;

public class AudioBookFactory extends Factory {
    private List<String> chapters = new ArrayList<String>();
    @Override
    public IContent createContent(String authorName) {
        System.out.println("Enter the name of the audiobook:");
        name = sc.nextLine();
        System.out.println("Enter the number of chapters");
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= size; i++) {
            System.out.printf("Enter a name of a chapter №%d \n", i);
            String chapterName = sc.nextLine();
            chapters.add(chapterName);
        }
        System.out.println("Enter the service level (1. basic, 2. premium, 3. ultra):");
        serviceLevel = Integer.parseInt(sc.nextLine());
        return new AudioBook(name, authorName, chapters, serviceLevel);
    }
}
