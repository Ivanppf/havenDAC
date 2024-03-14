package com.ippf.havendac.presentation.DTO.request;

import com.ippf.havendac.model.ENUM.PropertyType;
import jakarta.validation.constraints.NotNull;

public record PropertyRequestDTO(
        @NotNull PropertyType type,
        @NotNull Boolean isAvailable,
        @NotNull Boolean isCountryside,
        @NotNull Boolean hasSwimmingPool,
        @NotNull String description
) {
}
