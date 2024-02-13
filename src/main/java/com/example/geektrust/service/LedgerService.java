package com.example.geektrust.service;

import com.example.geektrust.command.Command;
import com.example.geektrust.command.CommandResult;
import com.example.geektrust.domain.Ledger;
import com.example.geektrust.domain.Ledgers;
import com.example.geektrust.domain.UserNotFoundException;
import com.example.geektrust.parser.Formatter;
import com.example.geektrust.parser.InputParser;

import java.util.List;

public class LedgerService {

    private final Ledgers ledgers;

    public LedgerService(Ledgers ledgers) {
        this.ledgers = ledgers;
    }

    public CommandResult runCommand(Command command) throws UserNotFoundException {
        Ledger ledger = ledgers.getLedger(command.getBank());
        return command.execute(ledger);
    }

    public TransactionStatus execute(String cmd) {
        TransactionStatus transactionStatus = new TransactionStatus();
        try {
            Command command = InputParser.parse(cmd);
            CommandResult result = this.runCommand(command);
            return transactionStatus.setResult(result);
        } catch (Exception e) {
            return transactionStatus.setError(e);
        }
    }

    public static void executeCommands(LedgerService ledgerService, List<String> commands, Formatter consoleFormatter) {
        for (String cmd : commands) {
            TransactionStatus transactionStatus = ledgerService.execute(cmd);
            transactionStatus.print(consoleFormatter);
        }
    }
}
