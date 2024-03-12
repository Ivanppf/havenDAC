package com.ippf.havendac.presentation.DTO;

import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.model.entities.Property;
import jakarta.validation.constraints.NotNull;

public record PropertyDTO(
        @NotNull PropertyType type,
        @NotNull boolean isAvailable,
        @NotNull boolean isCountryside,
        @NotNull boolean hasSwimmingPool,
        @NotNull String description
) implements DTO {
    public PropertyDTO(Property property) {
        this(property.getType(), property.isAvailable(), property.isCountryside(), property.isHasSwimmingPool(), property.getDescription());
    }
}
