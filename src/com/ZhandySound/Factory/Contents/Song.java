package com.ZhandySound.Factory.Contents;

import com.ZhandySound.Factory.IContent;

import java.util.List;

public class Song implements IContent {
    private String name;
    private String author;

    private int serviceLevel;
    public Song(String name, String author, int serviceLevel) {
        this.name = name;
        this.author = author;
        this.serviceLevel = serviceLevel;
    }

    @Override
    public void play() {
        System.out.printf("Playing the song %s by %s \n", name, author );
    }

    @Override
    public List<String> getChapters() {
        return null;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int getServiceLevel() {
        return serviceLevel;
    }
}
