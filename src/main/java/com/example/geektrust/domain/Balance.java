package com.example.geektrust.domain;

import java.util.Objects;

public class Balance {
    private final long amountPaid;
    private final int noOfEmisLeft;

    public Balance(long amountPaid, int noOfEmisLeft) {
        this.amountPaid = amountPaid;
        this.noOfEmisLeft = noOfEmisLeft;
    }

    public long amountPaid() {
        return amountPaid;
    }

    public int noOfEmisLeft() {
        return noOfEmisLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return amountPaid == balance.amountPaid && noOfEmisLeft == balance.noOfEmisLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountPaid, noOfEmisLeft);
    }
}
