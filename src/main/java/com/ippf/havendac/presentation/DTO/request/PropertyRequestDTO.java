package com.ippf.havendac.presentation.DTO.request;

import com.ippf.havendac.model.ENUM.PropertyType;
import jakarta.validation.constraints.NotNull;

public record PropertyRequestDTO(
        @NotNull PropertyType type,
        @NotNull boolean isAvailable,
        @NotNull boolean isCountryside,
        @NotNull boolean hasSwimmingPool,
        @NotNull String description
) implements RequestDTO {
}
