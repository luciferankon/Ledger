package com.example.geektrust.parser;

import com.example.geektrust.command.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    @Test
    void shouldBeAbleToParseTheGivenString() throws InvalidCommandException {
        String string = "LOAN IDIDI Dale 10000 5 4";
        Command lc = InputParser.parse(string);

        LoanCommand expected = new LoanCommand("IDIDI", "Dale", 10000, 5, 4);

        assertEquals(expected, lc);
    }

    @Test
    void shouldBeAbleToParseTheGivenBalanceCommand() throws InvalidCommandException {
        String string = "BALANCE IDIDI Dale 5";
        Command lc = InputParser.parse(string);

        Command expected = new BalanceCommand("IDIDI", "Dale", 5);

        assertEquals(expected, lc);
    }

    @Test
    void shouldBeAbleToParsePaymentCommand() throws InvalidCommandException {
        String string = "PAYMENT IDIDI Dale 1000 5";
        Command lc = InputParser.parse(string);

        Command expected = new PaymentCommand("IDIDI", "Dale", 1000,5);

        assertEquals(expected, lc);
    }

    @Test
    void shouldThrowInvalidCommandExceptionOnInvalidArguments() {
        String string = "PAYMENT";

        assertThrows(InvalidCommandException.class,()->InputParser.parse(string));

    }

    @Test
    void shouldThrowInvalidCommandExceptionOnInvalidCommands() {
        String string = "PAY IDIDI Dale 1000 1 5";

        assertThrows(InvalidCommandException.class,()->InputParser.parse(string));

    }
}