package com.ippf.havendac.presentation.DTO.response;

import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.model.entities.Property;

public record PropertyResponseDTO(
        int id,
        PropertyType type,
        boolean isAvailable,
        boolean isCountryside,
        boolean hasSwimmingPool,
        String description
) implements ResponseDTO {
    public PropertyResponseDTO(Property property) {
        this(property.getId(), property.getType(), property.isAvailable(), property.isCountryside(), property.isHasSwimmingPool(), property.getDescription());
    }
}
