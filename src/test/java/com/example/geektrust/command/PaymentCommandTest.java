package com.example.geektrust.command;

import com.example.geektrust.domain.Ledger;
import com.example.geektrust.domain.Loan;
import com.example.geektrust.domain.UserNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCommandTest {
    @Test
    void shouldBeAbleToPayForAnExistingLoan() throws UserNotFoundException {
        PaymentCommand paymentCommand = new PaymentCommand("IDI", "Bob", 5000, 0);
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("Bob", new Loan(12000, 1, 0));
        CommandResult commandResult = paymentCommand.execute(ledger);

        CommandResult expectedCommandCommandResult = new CommandResult(CommandType.PAYMENT);
        assertEquals(expectedCommandCommandResult, commandResult);
    }

    @Test
    void shouldNotAcceptPaymentForUnknownUser() {
        PaymentCommand paymentCommand = new PaymentCommand("IDI", "Bob", 1000, 0);
        Ledger ledger = new Ledger("IDI");

        assertThrows(UserNotFoundException.class, () -> paymentCommand.execute(ledger));
    }

    @Test
    void shouldThrowInvalidExceptionForWrongCommandParsing() {
        assertThrows(InvalidCommandException.class, () -> PaymentCommand.toPaymentCommand(new String[]{"1", "2"}));
    }
}