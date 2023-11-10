package com.ZhandySound;

import com.ZhandySound.Singleton.Database;
import com.ZhandySound.Strategy.Client;

import java.sql.Connection;
import java.util.Scanner;

public class ZhandySound {
    public static void main(String[] args) {
        Database db =  Database.getInstance();
        Connection conn = db.getConnection();
        Scanner sc = new Scanner(System.in);
        Client client = null;
        int option;
        System.out.println("1. Enter as a Listener");
        System.out.println("2. Enter as a Singer");
        System.out.println("1. Enter as a Writer");
        option = sc.nextInt();
        switch (option){
            case 1:
//                client = new;
            case 2:
                client = new

        }
    }
}
