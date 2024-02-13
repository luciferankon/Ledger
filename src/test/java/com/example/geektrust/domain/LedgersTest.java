package com.example.geektrust.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LedgersTest {
    @Test
    void shouldBeAbleToFindALedgerForAGivenBank() {
        Ledgers ledgers = new Ledgers();
        Ledger mbi = ledgers.getLedger("MBI");

        Ledger expectedLedger = new Ledger("MBI");

        assertEquals(expectedLedger,mbi);
    }

    @Test
    void shouldFindTheGivenExistingBankLedger() {
        Ledgers ledgers = new Ledgers();
        Ledger mbi = ledgers.getLedger("MBI");
        ledgers.getLedger("IDI");

        Ledger expectedLedger = ledgers.getLedger("MBI");

        assertEquals(expectedLedger,mbi);
    }
}