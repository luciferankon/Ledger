package com.example.geektrust;

import java.util.ArrayList;

public class UserLoan {

    private final float principal;
    private final int years;
    private final float roi;
    private final ArrayList<Payment> payments;

    public UserLoan(float principal, int years, float roi) {
        this.principal = principal;
        this.years = years;
        this.roi = roi;
        this.payments = new ArrayList<>();
    }

    public double getLeftOverEmis(int emiNo) {
        double emiReduced = Math.floor(getLumpSumPayments(emiNo) / getMonthlyEMI());
        return getTotalEMIs() - emiReduced - emiNo;
    }

    public double getLumpSumPayments(int emiNo) {
        return payments.stream()
                .filter(payment -> payment.isMadeBefore(emiNo))
                .mapToDouble(Payment::getAmount)
                .reduce(0.0, Double::sum);
    }

    public double getMonthlyEMI() {
        int noOfEmis = getTotalEMIs();
        float totalDue = getInterest() + principal;
        return Math.ceil(totalDue / noOfEmis);
    }

    public void pay(int emiNo, double amountPaid) {
        Payment payment = new Payment(emiNo, amountPaid);
        payments.add(payment);
    }

    public double getEmiPaid(int emiNo) {
        return getMonthlyEMI() * emiNo;
    }

    private int getTotalEMIs() {
        return years * 12;
    }

    private float getInterest() {
        return principal * years * roi / 100;
    }
}
