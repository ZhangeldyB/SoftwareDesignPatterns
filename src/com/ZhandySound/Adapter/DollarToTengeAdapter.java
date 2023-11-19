package com.ZhandySound.Adapter;

public class DollarToTengeAdapter extends TengePayment{
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
}
