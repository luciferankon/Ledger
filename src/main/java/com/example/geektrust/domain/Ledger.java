package com.example.geektrust.domain;

import java.util.HashMap;
import java.util.Objects;

public class Ledger {
    private final HashMap<String, Loan> accounts = new HashMap<String, Loan>();
    private final String bank;

    public Ledger(String bank) {
        this.bank = bank;
    }

    public void addLoan(String name, Loan loan) {
        accounts.put(name, loan);
    }

    public int count() {
        return accounts.size();
    }

    public Balance accountBalance(String name, int terms) throws UserNotFoundException {
        Loan loan = searchLoanAccount(name);
        return new Balance(loan.amountPaid(terms), loan.remainingEMI(terms));
    }

    public boolean ofSameBank(String bank) {
        return this.bank.equals(bank);
    }

    public boolean payment(String name, int lumSumAmount, int afterEmiTerms) throws UserNotFoundException {
        Loan loan = searchLoanAccount(name);
        return loan.addPayment(lumSumAmount, afterEmiTerms);
    }

    private Loan searchLoanAccount(String name) throws UserNotFoundException {
        if (!accounts.containsKey(name))
            throw new UserNotFoundException(name);
        return accounts.get(name);
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "accounts=" + accounts.keySet() +
                ", bank='" + bank + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ledger ledger = (Ledger) o;
        return Objects.equals(accounts, ledger.accounts) && Objects.equals(bank, ledger.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts, bank);
    }
}
