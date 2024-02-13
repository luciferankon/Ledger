package com.example.geektrust.service;

import com.example.geektrust.command.CommandResult;
import com.example.geektrust.command.CommandType;
import com.example.geektrust.command.InvalidCommandException;
import com.example.geektrust.domain.Ledgers;
import com.example.geektrust.domain.UserNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LedgerServiceTest {
    @Test
    void shouldExecuteCommandsOnLedger() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        String command = "LOAN IDI Bob 1000 1 1";
        TransactionStatus actual = ledgerService.execute(command);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setResult(new CommandResult(CommandType.LOAN));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldRecordErrorWhileExecutingCommand() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        String command = "BALANCE IDI Bob 1000 1 1";
        TransactionStatus actual = ledgerService.execute(command);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new UserNotFoundException("Bob"));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldRecordUnknownCommandWhileExecutingCommand() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        String command = "BAL IDI Bob 1000 1 1";
        TransactionStatus actual = ledgerService.execute(command);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new InvalidCommandException("BAL IDI Bob 1000 1 1"));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldReadTheGivenInputFileAndExecuteCommands() {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("LOAN IDIDI Dale 120 1 0");
        commands.add("BALANCE IDIDI Dale 6");
        LedgerService ledgerService = new LedgerService(new Ledgers());
        LedgerService.executeCommands(ledgerService, commands, s -> assertEquals("IDIDI Dale 60 6", s));
    }
}