package com.ZhandySound.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/ZhandySound";
    private String user = "postgres";
    private String password = "Pg_22_ZH";
    private Database(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return new Database();
    }
    public Connection getConnection() {
        return connection;
    }
}
