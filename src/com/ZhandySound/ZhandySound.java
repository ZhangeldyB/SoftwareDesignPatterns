package com.ZhandySound;

import com.ZhandySound.Adapter.DollarPayment;
import com.ZhandySound.Adapter.DollarToTengeAdapter;
import com.ZhandySound.Adapter.PaymentMachine;
import com.ZhandySound.Adapter.TengePayment;
import com.ZhandySound.Decorator.IAccessLevelDecorator;
import com.ZhandySound.Decorator.PremiumAccessDecorator;
import com.ZhandySound.Decorator.UltraAccessDecorator;
import com.ZhandySound.Strategy.*;

import java.sql.SQLException;
import java.util.Scanner;

public class ZhandySound {
    public static void main(String[] args) throws SQLException {
        DBFunctions dbf = new DBFunctions();
        Scanner sc = new Scanner(System.in);
        Client client = null;
        PaymentMachine paymentMachine = new PaymentMachine();
        int option;
        outerloop:
        while (true){
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            option = Integer.parseInt(sc.nextLine());
            boolean status = false;
            String session = "";
            switch (option) {
                case 1:
                    System.out.println("Enter the name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the password:");
                    String password = sc.nextLine();
                    System.out.println("1. Sign In as a Listener");
                    System.out.println("2. Sign In as a Singer");
                    System.out.println("3. Sign In as a Writer");
                    System.out.println("4. Exit");
                    option = Integer.parseInt(sc.nextLine());
                    switch (option) {
                        case 1:
                            client = new Client(new Listener(dbf), name, password);
                            status = dbf.checkClient(client, "Listeners");
                            client.setAccessLevel(dbf.getAccessLevel(client));
                            session = "Listener";
                            break;
                        case 2: {
                            client = new Client(new Singer(), name, password);
                            status = dbf.checkClient(client, "Singers");
                            session = "Singer";
                            break;
                        }
                        case 3: {
                            client = new Client(new Writer(), name, password);
                            status = dbf.checkClient(client, "Writers");
                            session = "Writer";
                            break;
                        }
                        case 4:
                            break;
                    }
                    if (status){
                        System.out.printf("Hello %s!\n", client.getName());
                    }else {
                        System.out.println("User does not exist! Check credentials or try to sign up.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name:");
                    name = sc.nextLine();
                    while (true) {
                        System.out.println("Enter the password:");
                        password = sc.nextLine();
                        System.out.println("Repeat the password:");
                        String password2 = sc.nextLine();
                        if (password2.equals(password)) {
                            break;
                        } else {
                            System.out.println("Passwords don't match");
                        }
                    }
                    System.out.println("1. Sign Up as a Listener");
                    System.out.println("2. Sign Up as a Singer");
                    System.out.println("3. Sign Up as a Writer");
                    System.out.println("4. Exit");
                    option = Integer.parseInt(sc.nextLine());
                    switch (option) {
                        case 1:{
                            client = new Client(new Listener(dbf), name, password);
                            dbf.addClient(client, "Listeners");
                            break;
                        }
                        case 2: {
                            client = new Client(new Singer(), name, password);
                            dbf.addClient(client, "Singers");
                            break;
                        }
                        case 3: {
                            client = new Client(new Writer(), name, password);
                            dbf.addClient(client, "Writers");
                            break;
                        }
                        case 4:
                            break;
                    }
                    break;
                case 3:
                    break outerloop;
            }
            if (status){
                secondOuter:
                while (true){
                    if (session.equals("Singer")){
                        System.out.println("1. Add a song");
                        System.out.println("2. Show my songs");
                        System.out.println("3. Log out");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option){
                            case 1:
                                dbf.addSong(client.action());
                                break;
                            case 2:
                                dbf.showSong(client.getName());
                                break;
                            case 3:
                                break secondOuter;
                        }
                    } else if (session.equals("Writer")) {
                        System.out.println("1. Add an audiobook");
                        System.out.println("2. Show my audiobooks");
                        System.out.println("3. Log out");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option){
                            case 1:
                                dbf.addAudioBook(client.action());
                                break;
                            case 2:
                                dbf.showAudioBook(client.getName());
                                break;
                            case 3:
                                break secondOuter;
                        }
                    }else {
                        System.out.println("1. Start Listening");
                        System.out.println("2. Upgrade Access Level for 500 tenge");
                        System.out.println("3. Log out");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option){
                            case 1:
                                client.listenToContent();
                                break;
                            case 2:
                                int clientAL = client.getAccessLevel();
                                if (clientAL == 3){
                                    System.out.println("You already have maximum access level");
                                } else if (clientAL == 2) {
                                    System.out.println("Your access level upgrading to ultra");
                                    System.out.println("Select the payment currency");
                                    System.out.println("1. KZT - Tenge");
                                    System.out.println("2. USD - Dollars");
                                    int currencyOption = Integer.parseInt(sc.nextLine());
                                    System.out.println("Enter the payment amount:");
                                    int payment = Integer.parseInt(sc.nextLine());
                                    boolean paymentStatus = false;
                                    if (currencyOption == 1) {
                                        TengePayment tengePayment = new TengePayment(payment);
                                        paymentStatus = paymentMachine.pay(tengePayment);
                                    }else {
                                        DollarPayment dollarPayment = new DollarPayment(payment);
                                        DollarToTengeAdapter dollarToTengePayment = new DollarToTengeAdapter(payment, dollarPayment);
                                        paymentStatus = paymentMachine.pay(dollarToTengePayment);
                                    }
                                    if (paymentStatus){
                                        IAccessLevelDecorator ultraListener = new UltraAccessDecorator(new Listener(dbf));
                                        client = new Client(ultraListener, client.getName(), client.getPassword());
                                        dbf.setAccessLevel(client, 3);
                                        System.out.println("Upgraded!");
                                    }else {
                                        System.out.println("Error!");
                                        break;
                                    }
                                }else {
                                    System.out.println("Your access level upgrading to premium");
                                    System.out.println("Select the payment currency");
                                    System.out.println("1. KZT - Tenge");
                                    System.out.println("2. USD - Dollars");
                                    int currencyOption = Integer.parseInt(sc.nextLine());
                                    System.out.println("Enter the payment amount:");
                                    int payment = Integer.parseInt(sc.nextLine());
                                    boolean paymentStatus = false;
                                    if (currencyOption == 1) {
                                        TengePayment tengePayment = new TengePayment(payment);
                                        paymentStatus = paymentMachine.pay(tengePayment);
                                    }else {
                                        DollarPayment dollarPayment = new DollarPayment(payment);
                                        DollarToTengeAdapter dollarToTengePayment = new DollarToTengeAdapter(payment, dollarPayment);
                                        paymentStatus = paymentMachine.pay(dollarToTengePayment);
                                    }
                                    if (paymentStatus){
                                        IAccessLevelDecorator premiumListener = new PremiumAccessDecorator(new Listener(dbf));
                                        client = new Client(premiumListener, client.getName(), client.getPassword());
                                        dbf.setAccessLevel(client, 2);
                                        System.out.println("Upgraded!");
                                    }else {
                                        System.out.println("Error!");
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                break secondOuter;
                        }
                    }
                }
            }
        }
    }
}
