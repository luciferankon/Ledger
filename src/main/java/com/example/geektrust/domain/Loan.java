package com.example.geektrust.domain;

public class Loan {
    private final double amount;
    private final int year;
    private final float rate;
    private final Payments payments = new Payments();

    public Loan(double amount, int year, float rate) {
        this.amount = amount;
        this.year = year;
        this.rate = rate;
    }

    public long totalAmount() {
        return round(amount + interest());
    }

    public long monthlyEMI() {
        return round(totalAmount() / timeInMonths());
    }

    private long remainingAmount(int terms) {
        return totalAmount() - amountPaid(terms);
    }

    public boolean addPayment(long lumSumAmount, int afterEmiTerms) {
        Payment payment = new Payment(afterEmiTerms, lumSumAmount);
        return this.payments.add(payment);
    }

    public long amountPaid(int terms) {
        long paidAsLumSum = payments.paymentsAfter(terms);
        return (terms * monthlyEMI()) + paidAsLumSum;
    }

    public int remainingEMI(int terms) {
        return (int) round( (double) remainingAmount(terms) / monthlyEMI());
    }

    private long round(double i) {
        return (long) Math.ceil(i);
    }

    private double interest() {
        return (amount * year * rate) / 100;
    }

    private float timeInMonths() {
        return year * 12;
    }
}
