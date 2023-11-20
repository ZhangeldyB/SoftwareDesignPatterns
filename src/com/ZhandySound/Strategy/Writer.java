package com.ZhandySound.Strategy;

import com.ZhandySound.Factory.Factories.AudioBookFactory;
import com.ZhandySound.Factory.IContent;

public class Writer implements IStrategy {
    @Override
    public IContent action(String name) {
        AudioBookFactory audioBookFactory = new AudioBookFactory();
        return audioBookFactory.createContent(name);
    }

}
