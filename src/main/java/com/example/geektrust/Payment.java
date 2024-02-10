package com.example.geektrust;

public class Payment {
    int emiTermNo;
    double amount;

    public Payment(int emiTermNo, double amount) {
        this.emiTermNo = emiTermNo;
        this.amount = amount;
    }

    public boolean isMadeBefore(int emiTerm) {
        return emiTermNo <= emiTerm;
    }

    public double getAmount() {
        return amount;
    }
}
