package com.bitforge.splitwise.strategies;

import com.bitforge.splitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
