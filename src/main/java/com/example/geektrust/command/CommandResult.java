package com.example.geektrust.command;

import java.util.Objects;

public class CommandResult {
    private final CommandType type;

    public CommandResult(CommandType type) {
        this.type = type;
    }

    public boolean isType(CommandType type) {
        return this.type == type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandResult that = (CommandResult) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
