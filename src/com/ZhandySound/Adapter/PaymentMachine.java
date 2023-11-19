package com.ZhandySound.Adapter;

public class PaymentMachine {
    private String currency = "KZT";
    private int upgradeCost = 500;
    public boolean pay(TengePayment tengePayment){
        if (tengePayment.getCurrency() == currency && tengePayment.getMoney()>=upgradeCost){
            System.out.println("Payment accepted!");
            return true;
        }else {
            System.out.println("Not enough money or wrong currency ");
            return false;
        }
    }
}
