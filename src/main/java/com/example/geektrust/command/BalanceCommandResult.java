package com.example.geektrust.command;

import java.util.Objects;

public class BalanceCommandResult extends CommandResult{
    private final String bank;
    private final String amount;
    private final String emiLeft;
    private final String name;

    public BalanceCommandResult(String bank, String name, String amount, String emiLeft) {
        super(CommandType.BALANCE);
        this.bank = bank;
        this.amount = amount;
        this.emiLeft = emiLeft;
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public String getAmountPaid() {
        return amount;
    }

    public String getNoOfEMIsLeft() {
        return emiLeft;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceCommandResult that = (BalanceCommandResult) o;
        return Objects.equals(bank, that.bank) && Objects.equals(amount, that.amount) && Objects.equals(emiLeft, that.emiLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, amount, emiLeft);
    }
}
