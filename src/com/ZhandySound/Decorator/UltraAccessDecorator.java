package com.ZhandySound.Decorator;

import com.ZhandySound.Factory.IContent;
import com.ZhandySound.Strategy.IStrategy;

public class UltraAccessDecorator implements IAccessLevelDecorator{
    private IStrategy strategy;

    public UltraAccessDecorator(IStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int decorateAccessLevel(int currentAccessLevel) {
        return Math.max(3, currentAccessLevel);
    }

    @Override
    public IStrategy getOriginalStrategy() {
        return strategy;
    }

    @Override
    public IContent action(String name) {
        return strategy.action(name);
    }
}
