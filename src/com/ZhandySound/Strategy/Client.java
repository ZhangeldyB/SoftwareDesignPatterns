package com.ZhandySound.Strategy;

import com.ZhandySound.Decorator.BasicAccessDecorator;
import com.ZhandySound.Decorator.IAccessLevelDecorator;
import com.ZhandySound.Factory.IContent;

import java.sql.SQLException;

public class Client {
    private IAccessLevelDecorator user;
    private String name;
    private String password;
    private int accessLevel;

    public Client(IStrategy strategy, String name, String password) {
        this.user = new BasicAccessDecorator(strategy);
        this.name = name;
        this.password = password;
    }

    public IContent action(){
        return user.action(name);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void listenToContent() throws SQLException {
        accessLevel = user.decorateAccessLevel(accessLevel);

        IStrategy originalStrategy = user;
        while (originalStrategy instanceof IAccessLevelDecorator) {
            originalStrategy = ((IAccessLevelDecorator) originalStrategy).getOriginalStrategy();
        }

        if (originalStrategy instanceof Listener) {
            ((Listener) originalStrategy).listenToContent(accessLevel);
        } else {
            System.out.println("This user cannot listen to music.");
        }
    }
}
