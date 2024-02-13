package com.example.geektrust.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ledgers {
    private final List<Ledger> ledgers = new ArrayList<>();

    public Ledger getLedger(String bank) {
        Optional<Ledger> optionalLedger = ledgers.stream()
                .filter((ledger) -> ledger.ofSameBank(bank))
                .findAny();
        if (optionalLedger.isEmpty()) {
            Ledger ledger = new Ledger(bank);
            ledgers.add(ledger);
            return ledger;
        }
        return optionalLedger.get();
    }
}
