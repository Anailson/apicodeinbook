package com.dev.codeinbook.common.dto;

import java.math.BigDecimal;

public record BookDTO(
        String id,
        String title,
        String subtitle,
        String description,
        BigDecimal price
) {
}
