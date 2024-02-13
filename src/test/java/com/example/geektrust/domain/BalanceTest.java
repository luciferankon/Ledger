package com.example.geektrust.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {
    @Test
    public void testAmountPaid() {
        Balance balance = new Balance(1000L, 5);
        assertEquals(1000L, balance.amountPaid());
    }

    @Test
    public void testNoOfEmisLeft() {
        Balance balance = new Balance(1000L, 5);
        assertEquals(5, balance.noOfEmisLeft());
    }

    @Test
    public void testEquals() {
        Balance balance1 = new Balance(1000L, 5);
        Balance balance2 = new Balance(1000L, 5);
        Balance balance3 = new Balance(2000L, 5);

        assertEquals(balance1, balance2);
        assertNotEquals(balance1, balance3);
    }

    @Test
    public void testHashCode() {
        Balance balance1 = new Balance(1000L, 5);
        Balance balance2 = new Balance(1000L, 5);
        Balance balance3 = new Balance(2000L, 5);

        assertEquals(balance1.hashCode(), balance2.hashCode());
        assertNotEquals(balance1.hashCode(), balance3.hashCode());
    }
}