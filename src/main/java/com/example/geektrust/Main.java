package com.example.geektrust;

import com.example.geektrust.service.LedgerService;

public class Main {
    public static void main(String[] args) {
        LedgerService ledgerService = new LedgerService();
//        company.registerLoan("IDIDI","Dale",10000,5,4);
//        company.registerLoan("MBI","Harry",2000,2,2);
//        company.printBalance("IDIDI","Dale",5);
//        company.printBalance("IDIDI","Dale",40);
//        company.printBalance("MBI","Harry",12);
//        company.printBalance("MBI","Harry",0);

        // second one
        ledgerService.registerLoan("IDIDI","Dale",5000,1,6);
        ledgerService.registerLoan("MBI","Harry",10000,3,7);
        ledgerService.registerLoan("UON","Shelly",15000,2,9);
        ledgerService.makePayment("IDIDI","Dale",1000,5);
        ledgerService.makePayment("MBI","Harry",5000,10);
        ledgerService.makePayment("UON","Shelly",7000,12);
        ledgerService.printBalance("IDIDI","Dale",3);
        ledgerService.printBalance("IDIDI","Dale",6);
        ledgerService.printBalance("UON","Shelly",12);
        ledgerService.printBalance("MBI","Harry",12);
//        try {
//            FileInputStream fis = new FileInputStream(args[0]);
//            Scanner sc = new Scanner(fis);
//            while (sc.hasNextLine()) {
//
//            }
//            sc.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
