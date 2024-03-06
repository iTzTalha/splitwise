package com.bitforge.splitwise.factories;

import com.bitforge.splitwise.enums.SettleUpStrategyType;
import com.bitforge.splitwise.strategies.SettleUpHeapStrategy;
import com.bitforge.splitwise.strategies.SettleUpStrategy;

public class SettleUpHeapStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategyByType(SettleUpStrategyType type) {
        if (type == SettleUpStrategyType.HEAP) {
            return new SettleUpHeapStrategy();
        }
        return null;
    }
}
