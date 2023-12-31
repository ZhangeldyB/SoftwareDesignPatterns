package com.ZhandySound.Factory;

import java.util.Scanner;

abstract public class Factory {
    protected String name;
    protected int serviceLevel;

    protected Scanner sc = new Scanner(System.in);

    public abstract IContent createContent(String author);
}
