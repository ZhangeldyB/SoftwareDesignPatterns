package com.ZhandySound.Strategy;

import com.ZhandySound.Factory.IContent;

public interface IStrategy {
    IContent action(String name);
}
