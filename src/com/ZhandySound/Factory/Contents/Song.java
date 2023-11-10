package com.ZhandySound.Factory.Contents;

import com.ZhandySound.Factory.IContent;

public class Song implements IContent {
    private String name;
    private String author;

    public Song(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public void play() {
        System.out.printf("Playing the song %s by %s \n", name, author );
    }
}
