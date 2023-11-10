package com.ZhandySound.Factory.Factories;

import com.ZhandySound.Factory.Contents.Song;
import com.ZhandySound.Factory.Factory;
import com.ZhandySound.Factory.IContent;

import java.util.Scanner;

public class SongFactory extends Factory {
    @Override
    public IContent createContent(String authorName){
        System.out.println("Enter the name of the song:");
        name = sc.nextLine();
        return new Song(name, authorName);
    }
}
