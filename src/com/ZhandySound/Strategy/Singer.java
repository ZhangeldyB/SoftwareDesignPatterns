package com.ZhandySound.Strategy;

import com.ZhandySound.Decorator.IAccessLevelDecorator;
import com.ZhandySound.Factory.Factories.SongFactory;
import com.ZhandySound.Factory.IContent;

public class Singer implements IStrategy {

    @Override
    public IContent action(String name) {
        SongFactory songFactory = new SongFactory();
        IContent content = songFactory.createContent(name);
        return content;
    }

}
