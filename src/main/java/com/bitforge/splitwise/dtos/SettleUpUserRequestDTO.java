package com.bitforge.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SettleUpUserRequestDTO {
    private Long userId;
}
