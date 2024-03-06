package com.bitforge.splitwise.commands;

import com.bitforge.splitwise.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private final List<Command> commands;

    @Autowired
    public CommandExecutor(SettleUpUserCommand settleUpUserCommand, SettleUpGroupCommand settleUpGroupCommand) {
        commands = new ArrayList<>();
        commands.add(settleUpUserCommand);
        commands.add(settleUpGroupCommand);
    }

    public void execute(String input) throws InvalidCommandException {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                return;
            }
        }

        throw new InvalidCommandException();
    }
}
