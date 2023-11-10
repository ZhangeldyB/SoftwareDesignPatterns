package com.ZhandySound.Strategy;

public class Client {
    IStrategy user;
    private String name;

    public Client(IStrategy user, String name) {
        this.user = user;
        this.name = name;
    }

    void action(){
        user.action(name);
    }
}
