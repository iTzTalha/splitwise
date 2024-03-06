package com.bitforge.splitwise.commands;

import com.bitforge.splitwise.exceptions.InvalidCommandException;

public interface Command {
    boolean matches(String input) throws InvalidCommandException;
    void execute(String input);
}
