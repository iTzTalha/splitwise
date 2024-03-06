package com.bitforge.splitwise.commands;

import com.bitforge.splitwise.controllers.SettleUpController;
import com.bitforge.splitwise.dtos.SettleUpUserRequestDTO;
import com.bitforge.splitwise.dtos.SettleUpUserResponseDTO;
import com.bitforge.splitwise.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command {
    private final SettleUpController settleUpController;

    @Autowired
    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) throws InvalidCommandException {
        List<String> words = List.of(input.split(" "));
        if(!words.get(0).equalsIgnoreCase("SettleUpUser")) {
            throw new InvalidCommandException();
        }
        return true;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(1));

        SettleUpUserResponseDTO responseDTO = settleUpController.settleUpUser(SettleUpUserRequestDTO.builder().userId(userId).build());
    }
}
