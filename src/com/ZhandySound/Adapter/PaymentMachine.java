package com.ZhandySound.Adapter;

import com.ZhandySound.Observer.IPaymentStatusObserver;

import java.util.ArrayList;
import java.util.List;

public class PaymentMachine {
    private String currency = "KZT";
    private int upgradeCost = 500;
    private List<IPaymentStatusObserver> paymentStatusObservers = new ArrayList<>();
    public void addPaymentStatusObserver(IPaymentStatusObserver observer) {
        paymentStatusObservers.add(observer);
    }
    public boolean pay(TengePayment tengePayment){
        boolean paymentStatus = tengePayment.getCurrency().equals(currency) && tengePayment.getMoney()>=upgradeCost;
        for (IPaymentStatusObserver observer : paymentStatusObservers) {
            observer.updatePaymentStatus(paymentStatus);
        }
        if (paymentStatus){
            System.out.println("Payment accepted!");
            return true;
        }else {
            System.out.println("Not enough money or wrong currency ");
            return false;
        }
    }
}
