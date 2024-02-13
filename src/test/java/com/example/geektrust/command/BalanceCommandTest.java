package com.example.geektrust.command;

import com.example.geektrust.domain.Ledger;
import com.example.geektrust.domain.Loan;
import com.example.geektrust.domain.UserNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceCommandTest {
    @Test
    void shouldFetchTheUsersBalance() throws UserNotFoundException {
        BalanceCommand balanceCommand = new BalanceCommand("IDI", "Bob", 0);
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("Bob", new Loan(200, 1, 1));
        CommandResult commandResult = balanceCommand.execute(ledger);

        BalanceCommandResult expectedCommandResult = new BalanceCommandResult("IDI", "Bob", "0", "12");
        assertEquals(expectedCommandResult, commandResult);
    }

    @Test
    void shouldThrowExceptionForInvalidUser() {
        BalanceCommand balanceCommand = new BalanceCommand("IDI", "Bob", 1);
        Ledger ledger = new Ledger("IDI");

        assertThrows(UserNotFoundException.class, () -> balanceCommand.execute(ledger));
    }

    @Test
    void shouldThrowInvalidExceptionForWrongCommandParsing() {
        assertThrows(InvalidCommandException.class, () -> BalanceCommand.toBalanceCommand(new String[]{"1", "2"}));
    }
}