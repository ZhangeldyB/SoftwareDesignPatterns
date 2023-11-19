package com.ZhandySound;

import com.ZhandySound.Factory.IContent;
import com.ZhandySound.Singleton.Database;
import com.ZhandySound.Strategy.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFunctions {
    private Database db = Database.getInstance();
    private Connection conn = db.getConnection();

    void addClient(Client client, String type) throws SQLException {
        try{
            Statement query = conn.createStatement();
            query.executeUpdate("INSERT INTO public.\"" + type + "\" (name, password) VALUES ('" + client.getName() + "','" + client.getPassword() +"')");
            System.out.println(client.getName() + " successfully added!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    boolean checkClient(Client client, String type) throws SQLException{
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM \"" + type + "\" WHERE name = '" + client.getName() + "' AND password = '" + client.getPassword() + "';");
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    void addAudioBook (IContent audioBook) throws SQLException{
        try {
            Statement statement = conn.createStatement();
            String chaptersString = "{" + String.join(", ", audioBook.getChapters()) + "}";
            String query = String.format("INSERT INTO \"AudioBooks\" (\"audioBookName\", chapters, author, \"serviceLevel\") VALUES ('%s', '%s', '%s', '%s')", audioBook.getName(), chaptersString, audioBook.getAuthor(), audioBook.getServiceLevel());
            statement.executeUpdate(query);
            System.out.println("Audiobook added!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    void addSong(IContent song) throws SQLException{
        try {
            Statement statement = conn.createStatement();
            String query = String.format("INSERT INTO public.\"Songs\" (\"songName\", author, \"serviceLevel\") VALUES ('%s', '%s', '%s')", song.getName(), song.getAuthor(), song.getServiceLevel());
            statement.executeUpdate(query);
            System.out.println("Song added!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    void showSong(String authorName) throws SQLException{
        try {
            String query = String.format("SELECT * FROM public.\"Songs\" WHERE author = '%s'", authorName);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----------------------");
            while (resultSet.next()) {
                String songName = resultSet.getString("songName");
                String author = resultSet.getString("author");

                System.out.println("Song Name: " + songName);
                System.out.println("Author: " + author);
                System.out.println("----------------------");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void showAudioBook(String authorName) throws SQLException{
        try {
            String query = String.format("SELECT * FROM public.\"AudioBooks\" WHERE author = '%s'", authorName);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----------------------");
            while (resultSet.next()) {
                String audioBookName = resultSet.getString("audioBookName");
                String[] chapters = resultSet.getString("chapters").split(", ");
                String author = resultSet.getString("author");

                System.out.println("AudioBook Name: " + audioBookName);
                System.out.print("Chapters: ");
                for (int i = 0; i < chapters.length; i++) {
                    System.out.print(chapters[i]);
                    if (i < chapters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\nAuthor: " + author);
                System.out.println("----------------------");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listenToMusic(int accessLevel, String songName) throws SQLException{
        try {
            Statement statement = conn.createStatement();
            String query = String.format( "SELECT * FROM public.\"Songs\" WHERE \"songName\" = '%s' AND \"serviceLevel\" <= %d", songName, accessLevel);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) System.out.printf("Listening to the %s by %s \n", resultSet.getString("songName"), resultSet.getString("author"));
            else System.out.println("There is no such song or your access level is too low");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void listenToAudioBook(int accessLevel, String audioBookName) throws SQLException{
        try {
            Statement statement = conn.createStatement();
            String query = String.format("SELECT * FROM public.\"AudioBooks\" WHERE \"audioBookName\" = '%s' AND \"serviceLevel\" <= %d", audioBookName, accessLevel);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                System.out.printf("Listening to the '%s' by %s \n", resultSet.getString("audioBookName"), resultSet.getString("author"));
                String[] chapters = resultSet.getString("chapters").split(", ");
                for (int i = 0; i < chapters.length; i++) {
                    System.out.printf("Chapters: %s", i+1);
                    if (i < chapters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }else System.out.println("There is no such audiobook or your access level is too low");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getAccessLevel(Client client) {
        try {
            Statement statement = conn.createStatement();
            String query = String.format("SELECT \"accessLevel\" FROM public.\"Listeners\" WHERE name = '%s'", client.getName());
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt("accessLevel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public void setAccessLevel(Client client, int accessLevel) {
        try {
            Statement statement = conn.createStatement();
            String updateQuery = String.format("UPDATE public.\"Listeners\" SET \"accessLevel\" = %d WHERE name = '%s'", accessLevel, client.getName());
            statement.executeUpdate(updateQuery);
            client.setAccessLevel(accessLevel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
