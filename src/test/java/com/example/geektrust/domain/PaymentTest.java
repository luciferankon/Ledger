package com.example.geektrust.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    @Test
    public void testSmallerThanEqualTo() {
        Payment payment = new Payment(5, 1000L);

        assertFalse(payment.smallerThanEqualTo(3)); // 5 >= 3
        assertTrue(payment.smallerThanEqualTo(7)); // 5 < 7
        assertTrue(payment.smallerThanEqualTo(5)); // 5 >= 5
    }

    @Test
    public void testAmount() {
        Payment payment = new Payment(5, 1000L);

        assertEquals(1000L, (long) payment.amount());
    }
}