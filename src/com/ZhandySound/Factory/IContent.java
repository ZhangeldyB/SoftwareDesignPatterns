package com.ZhandySound.Factory;

import java.util.List;

public interface IContent {
    void play();

    String getName();

    String getAuthor();

    int getServiceLevel();
    List<String> getChapters();
}
