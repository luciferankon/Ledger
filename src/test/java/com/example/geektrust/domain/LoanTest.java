package com.example.geektrust.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    @Test
    void shouldCalculateTotalLoanAmountUsingSimpleInterest() {
        Loan loan = new Loan(10000, 5, 4);
        long amount = loan.totalAmount();

        assertEquals(12000, amount);
    }

    @Test
    void shouldCalculateMonthlyEMITobePaid() {
        Loan loan = new Loan(10000, 5, 4);
        long emi = loan.monthlyEMI();

        assertEquals(200, emi);
    }

    @Test
    void shouldRoundOffAndCalculateMonthlyEMITobePaid() {
        Loan loan = new Loan(2000, 2, 2);
        long emi = loan.monthlyEMI();

        assertEquals(87, emi);
    }

    @Test
    void shouldGetRemainingNumberOfEMIsToBePaid() {
        Loan loan = new Loan(2000, 2, 2);
        int remainingEMIs = loan.remainingEMI(4);

        assertEquals(20, remainingEMIs);
    }

    @Test
    void shouldGetPaidAmount() {
        Loan loan = new Loan(2000, 2, 2);
        long amountPaid = loan.amountPaid(4);

        assertEquals(348, amountPaid);
    }

    @Test
    void shouldAcceptLumSumPaymentForTheLoan() {
        Loan loan = new Loan(1200, 1, 0);
        loan.addPayment(1000, 2);

        long amountPaid = loan.amountPaid(2);
        int remainingEMI = loan.remainingEMI(2);
        assertEquals(1200, amountPaid);
        assertEquals(0, remainingEMI);
    }

    @Test
    void shouldNotAddTheLumSumAmountInTotalForOlderPayments() {
        Loan loan = new Loan(5000, 1, 6);
        loan.addPayment(1000,5);
        int remainingEMI = loan.remainingEMI(3);
        assertEquals(9,remainingEMI);

        int remainingEMIAfterPayment = loan.remainingEMI(6);
        assertEquals(4,remainingEMIAfterPayment);
    }
}