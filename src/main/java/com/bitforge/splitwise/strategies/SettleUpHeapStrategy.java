package com.bitforge.splitwise.strategies;

import com.bitforge.splitwise.models.Expense;

import java.util.ArrayList;
import java.util.List;

public class SettleUpHeapStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //TODO:: write a min & max heap logic to settle up expenses
        return new ArrayList<>();
    }
}
