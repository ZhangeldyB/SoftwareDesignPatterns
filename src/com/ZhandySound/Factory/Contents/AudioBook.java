package com.ZhandySound.Factory.Contents;

import com.ZhandySound.Factory.IContent;

import java.util.List;

public class AudioBook implements IContent {
    private String name;
    private String author;
    private List<String> chapters;

    private int serviceLevel;

    public AudioBook(String name, String author, List<String> chapters, int serviceLevel) {
        this.name = name;
        this.author = author;
        this.chapters = chapters;
        this.serviceLevel = serviceLevel;
    }
    @Override
    public void play() {
        for (String chapter:
             chapters) {
            playChapter(chapter);
        }
    }
    public void playChapter(String chapter) {
        System.out.printf("Playing the chapter \"%s\" from %s by %s \n", chapter, name, author );
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public int getServiceLevel() {
        return serviceLevel;
    }
}
