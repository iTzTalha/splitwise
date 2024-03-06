package com.bitforge.splitwise.controllers;

import com.bitforge.splitwise.dtos.SettleUpGroupRequestDTO;
import com.bitforge.splitwise.dtos.SettleUpGroupResponseDTO;
import com.bitforge.splitwise.dtos.SettleUpUserRequestDTO;
import com.bitforge.splitwise.dtos.SettleUpUserResponseDTO;
import com.bitforge.splitwise.enums.ResponseStatus;
import com.bitforge.splitwise.models.Expense;
import com.bitforge.splitwise.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private final SettleUpService settleUpService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO requestDTO) {
        SettleUpUserResponseDTO responseDTO = new SettleUpUserResponseDTO();
        try {
            List<Expense> expenses = settleUpService.settleUpUser(requestDTO.getUserId());
            responseDTO.setExpenses(expenses);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO requestDTO) {
        SettleUpGroupResponseDTO responseDTO = new SettleUpGroupResponseDTO();
        try {
            List<Expense> expenses = settleUpService.settleUpGroup(requestDTO.getGroupId());
            responseDTO.setExpenses(expenses);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
