package com.example.geektrust.command;
import com.example.geektrust.domain.Ledger;
import com.example.geektrust.domain.UserNotFoundException;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class PaymentCommand implements Command{
    private final String bank;
    private final String name;
    private final int lumSumAmount;
    private final int emiTerms;

    public PaymentCommand(String bank, String name, int lumSumAmount, int emiTerms) {
        this.bank = bank;
        this.name = name;
        this.lumSumAmount = lumSumAmount;
        this.emiTerms = emiTerms;
    }

    @Override
    public CommandResult execute(Ledger ledger) throws UserNotFoundException {
        ledger.payment(name, lumSumAmount, emiTerms);
        return new CommandResult(CommandType.PAYMENT);
    }

    @Override
    public String getBank() {
        return bank;
    }

    public static PaymentCommand toPaymentCommand(String[] args) throws InvalidCommandException {
        try {
            return new PaymentCommand(args[1], args[2], parseInt(args[3]), parseInt(args[4]));
        } catch (Exception e) {
            throw new InvalidCommandException(String.join(" ", args));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentCommand that = (PaymentCommand) o;
        return lumSumAmount == that.lumSumAmount && emiTerms == that.emiTerms && Objects.equals(bank, that.bank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, name, lumSumAmount, emiTerms);
    }
}
