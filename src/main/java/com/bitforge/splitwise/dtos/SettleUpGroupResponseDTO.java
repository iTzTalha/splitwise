package com.bitforge.splitwise.dtos;

import com.bitforge.splitwise.enums.ResponseStatus;
import com.bitforge.splitwise.models.Expense;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpGroupResponseDTO {
    private List<Expense> expenses;
    private ResponseStatus responseStatus;
}
