package com.ZhandySound.Adapter;

import com.ZhandySound.Observer.IPaymentStatusObserver;

public class TengePayment implements IPaymentStatusObserver {
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

    @Override
    public void updatePaymentStatus(boolean paymentStatus) {
        System.out.println("Payment status for Tenge currency: " + (paymentStatus ? "Success" : "Failed"));
    }
}
