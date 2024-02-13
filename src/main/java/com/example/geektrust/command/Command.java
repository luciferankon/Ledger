package com.example.geektrust.command;

import com.example.geektrust.domain.Ledger;
import com.example.geektrust.domain.UserNotFoundException;

public interface Command {
    CommandResult execute(Ledger ledger) throws UserNotFoundException;
    String getBank();
}
