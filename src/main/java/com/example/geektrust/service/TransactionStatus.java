package com.example.geektrust.service;

import com.example.geektrust.command.BalanceCommandResult;
import com.example.geektrust.command.CommandResult;
import com.example.geektrust.command.CommandType;
import com.example.geektrust.parser.Formatter;

import java.util.Objects;

public class TransactionStatus {
    private Exception error;
    private CommandResult cmdCommandResult;

    public TransactionStatus setResult(CommandResult commandResult) {
        this.cmdCommandResult = commandResult;
        return this;
    }

    public TransactionStatus setError(Exception e) {
        this.error = e;
        return this;
    }

    public void print(Formatter formatter) {
        if (this.error != null) {
            formatter.println(error.getMessage());
        }
        if (this.cmdCommandResult != null && cmdCommandResult.isType(CommandType.BALANCE)) {
            BalanceCommandResult cmd = (BalanceCommandResult) this.cmdCommandResult;
            String result = String.format("%s %s %s %s", cmd.getBank(), cmd.getName(), cmd.getAmountPaid(), cmd.getNoOfEMIsLeft());
            formatter.println(result);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionStatus that = (TransactionStatus) o;
        if (error != null) return Objects.equals(error.getMessage(), that.error.getMessage());
        return Objects.equals(cmdCommandResult, that.cmdCommandResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, cmdCommandResult);
    }
}
