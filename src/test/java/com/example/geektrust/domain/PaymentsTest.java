package com.example.geektrust.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentsTest {
    @Test
    public void testPaymentsAfter() {
        Payments payments = new Payments();
        payments.add(new Payment(3, 1000L));
        payments.add(new Payment(5, 1500L));
        payments.add(new Payment(7, 2000L));

        assertEquals(0L, payments.paymentsAfter(0));
        assertEquals(1000L, payments.paymentsAfter(4));
        assertEquals(1000L + 1500L, payments.paymentsAfter(6));
        assertEquals(1000L + 1500L + 2000L, payments.paymentsAfter(8));
    }

}