package com.bitforge.splitwise.commands;

import com.bitforge.splitwise.controllers.SettleUpController;
import com.bitforge.splitwise.dtos.SettleUpUserRequestDTO;
import com.bitforge.splitwise.dtos.SettleUpUserResponseDTO;
import com.bitforge.splitwise.exceptions.InvalidCommandException;

import java.util.List;

public class SettleUpGroupCommand implements Command {
    private final SettleUpController settleUpController;

    public SettleUpGroupCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) throws InvalidCommandException {
        List<String> words = List.of(input.split(" "));
        if(!words.get(0).equalsIgnoreCase("SettleUpGroup")) {
            throw new InvalidCommandException();
        }
        return true;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long groupId = Long.valueOf(words.get(1));

        SettleUpUserResponseDTO responseDTO = settleUpController.settleUpUser(SettleUpUserRequestDTO.builder().userId(groupId).build());
    }
}
