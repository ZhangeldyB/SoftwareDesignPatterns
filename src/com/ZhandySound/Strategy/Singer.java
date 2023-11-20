package com.ZhandySound.Strategy;

import com.ZhandySound.Factory.Factories.SongFactory;
import com.ZhandySound.Factory.IContent;

public class Singer implements IStrategy {

    @Override
    public IContent action(String name) {
        SongFactory songFactory = new SongFactory();
        return songFactory.createContent(name);
    }

}
