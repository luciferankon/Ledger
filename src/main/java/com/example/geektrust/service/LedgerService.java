package com.example.geektrust.service;

import com.example.geektrust.UserLoan;

import java.util.HashMap;

public class LedgerService {
    HashMap<String, UserLoan> userLedger = new HashMap<>();

    public LedgerService() {}

    public void registerLoan(String bankName, String borrowerName, float principal, int years, float roi) {
        UserLoan userLoan = new UserLoan(principal, years, roi);
        String borrowerBankId = getKey(bankName, borrowerName);
        userLedger.put(borrowerBankId, userLoan);
    }

    public void makePayment(String bankName, String borrowerName, int lumpsum, int emiNo) {
        UserLoan userLoan = getUserLoan(bankName, borrowerName);
        userLoan.pay(emiNo, lumpsum);
    }

    public void printBalance(String bankName, String borrowerName, int emiNo) {
        UserLoan userLoan = getUserLoan(bankName, borrowerName);
        double amountPaid = getAmountPaid(emiNo, userLoan);
        double noOfEmiLeft = userLoan.getLeftOverEmis(emiNo);
        System.out.println(bankName + " " + borrowerName + " " + (int) amountPaid + " " + (int) noOfEmiLeft);
    }

    private static String getKey(String bankName, String borrowerName) {
        return bankName + borrowerName;
    }

    private UserLoan getUserLoan(String bankName, String borrowerName) {
        String borrowerBankId = getKey(bankName, borrowerName);
        return userLedger.get(borrowerBankId);
    }

    private static double getAmountPaid(int emiNo, UserLoan userLoan) {
        double lumpSumPayments = userLoan.getLumpSumPayments(emiNo);
        double emiPaid = userLoan.getEmiPaid(emiNo);
        return emiPaid + lumpSumPayments;
    }
}
