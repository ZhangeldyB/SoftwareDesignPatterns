package com.ZhandySound.Decorator;

import com.ZhandySound.Strategy.IStrategy;

public interface IAccessLevelDecorator extends IStrategy {
    int decorateAccessLevel(int currentAccessLevel);

    IStrategy getOriginalStrategy();
}
