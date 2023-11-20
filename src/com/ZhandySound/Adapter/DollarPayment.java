package com.ZhandySound.Adapter;

public class DollarPayment {
    private String currency = "USD";
    private int money;

    public DollarPayment(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
