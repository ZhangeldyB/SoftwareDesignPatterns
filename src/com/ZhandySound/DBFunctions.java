package com.ZhandySound;

import com.ZhandySound.Singleton.Database;
import com.ZhandySound.Strategy.Client;

import java.sql.Connection;

public class DBFunctions {
    Database db = Database.getInstance();
    Connection conn = db.getConnection();

    void addUser(Client user){
        String querry = conn.createStatement("")
    }
}
