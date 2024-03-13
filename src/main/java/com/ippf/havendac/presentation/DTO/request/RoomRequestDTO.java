package com.ippf.havendac.presentation.DTO.request;

import jakarta.validation.constraints.NotNull;

public record RoomRequestDTO(
        @NotNull(message = "Please insert the room length") float length,
        @NotNull(message = "Please insert the room width") float width,
        @NotNull(message = "Please insert the property id") int propertyId
) implements RequestDTO {
}
