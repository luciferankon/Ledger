package com.example.geektrust.command;

import com.example.geektrust.domain.Ledger;
import com.example.geektrust.domain.Loan;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class LoanCommand implements Command{
    private final String bank;
    private final String name;
    private final int amount;
    private final int years;
    private final int roi;

    public LoanCommand(String bank, String name, int amount, int years, int roi) {
        this.bank = bank;
        this.name = name;
        this.amount = amount;
        this.years = years;
        this.roi = roi;
    }

    public CommandResult execute(Ledger ledger) {
        Loan loan = new Loan(amount, years, roi);
        ledger.addLoan(name, loan);
        return new CommandResult(CommandType.LOAN);
    }

    @Override
    public String getBank() {
        return this.bank;
    }

    public static LoanCommand toLoanCommand(String[] args) throws InvalidCommandException {
        try {
            return new LoanCommand(args[1], args[2], parseInt(args[3]), parseInt(args[4]), parseInt(args[5]));
        } catch (Exception e) {
            throw new InvalidCommandException(String.join(" ", args));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanCommand that = (LoanCommand) o;
        return amount == that.amount && years == that.years && roi == that.roi && Objects.equals(bank, that.bank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, name, amount, years, roi);
    }

}
