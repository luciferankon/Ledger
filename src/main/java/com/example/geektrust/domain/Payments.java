package com.example.geektrust.domain;

import java.util.ArrayList;

public class Payments extends ArrayList<Payment> {
    public long paymentsAfter(int terms) {
        return this.stream()
                .filter((p) -> p.smallerThanEqualTo(terms))
                .mapToLong(Payment::amount)
                .sum();
    }
}
