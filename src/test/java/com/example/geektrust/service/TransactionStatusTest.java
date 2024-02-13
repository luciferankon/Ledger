package com.example.geektrust.service;

import com.example.geektrust.command.BalanceCommandResult;
import com.example.geektrust.domain.UserNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionStatusTest {
    @Test
    void printerPrintsTheResultWhenThereIsNoError() {
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setResult(new BalanceCommandResult("bank", "name", "22","12"));

        transactionStatus.print(x -> assertEquals("bank name 22 12",x));

    }

    @Test
    void printerPrintsTheErrorWhenThereIsError() {
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new UserNotFoundException("name"));

        transactionStatus.print(x -> assertEquals("User name not found",x));

    }
}