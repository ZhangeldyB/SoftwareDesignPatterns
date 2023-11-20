package com.ZhandySound.Strategy;

import com.ZhandySound.DBFunctions;
import com.ZhandySound.Factory.IContent;

import java.sql.SQLException;
import java.util.Scanner;

public class Listener implements IStrategy  {
    private DBFunctions dbf;

    public Listener(DBFunctions dbf) {
        this.dbf = dbf;
    }
    @Override
    public IContent action(String name) {
        return null;
    }
    public void listenToContent(int accessLevel) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Listen to the Music");
        System.out.println("2. Listen to the AudioBook");
        int option = Integer.parseInt(sc.nextLine());
        if (option == 1) {
            System.out.println("Enter the name of the song:");
            dbf.listenToMusic(accessLevel, sc.nextLine());
        }
        else {
            System.out.println("Enter the name of audiobook:");
            dbf.listenToAudioBook(accessLevel, sc.nextLine());
        }
    }

}
