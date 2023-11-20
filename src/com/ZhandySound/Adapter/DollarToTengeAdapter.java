package com.ZhandySound.Adapter;

import com.ZhandySound.Observer.IPaymentStatusObserver;

public class DollarToTengeAdapter extends TengePayment implements IPaymentStatusObserver {
    private DollarPayment dollarPayment;

    public DollarToTengeAdapter(int money, DollarPayment dollarPayment) {
        super(money);
        this.dollarPayment = dollarPayment;
    }

    @Override
    public String getCurrency() {
        return "KZT";
    }

    @Override
    public int getMoney() {
        return dollarPayment.getMoney() * 460;
    }

    @Override
    public void updatePaymentStatus(boolean paymentStatus) {
        System.out.println("Payment status for Dollars currency: " + (paymentStatus ? "Success" : "Failed"));
    }
}
