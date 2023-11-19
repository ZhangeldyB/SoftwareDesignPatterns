package com.ZhandySound.Adapter;

public class TengePayment {
    private String currency = "KZT";
    private int money;

    public TengePayment(int money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public int getMoney() {
        return money;
    }
}
