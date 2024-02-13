package com.example.geektrust.command;

import com.example.geektrust.domain.Ledger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCommandTest {
    @Test
    void shouldBeAbleToCreateALoanWithLoanCommand() {
        LoanCommand loanCommand = new LoanCommand("IDI", "Bob", 1000, 1, 1);
        Ledger ledger = new Ledger("IDI");
        CommandResult commandResult = loanCommand.execute(ledger);

        CommandResult expectedCommandCommandResult = new CommandResult(CommandType.LOAN);
        assertEquals(expectedCommandCommandResult, commandResult);
    }

    @Test
    void shouldThrowInvalidExceptionForWrongCommandParsing() {
        assertThrows(InvalidCommandException.class, () -> LoanCommand.toLoanCommand(new String[]{"1", "2"}));
    }
}