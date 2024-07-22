package com.ippf.havendac.presentation.DTO.request;

import com.ippf.havendac.model.ENUM.PropertyType;
import jakarta.validation.constraints.NotNull;

public record PropertyRequestDTO(
        @NotNull(message = "Please insert the property type") PropertyType propertyType,
        @NotNull(message = "Please inform if the property is available") Boolean isAvailable,
        @NotNull(message = "Please inform if the property is countryside") Boolean isCountryside,
        @NotNull(message = "Please inform if the property has a swimming pool") Boolean hasSwimmingPool,
        @NotNull(message = "Please insert the property description") String description) {
}
