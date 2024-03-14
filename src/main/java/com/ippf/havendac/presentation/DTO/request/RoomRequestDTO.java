package com.ippf.havendac.presentation.DTO.request;

import jakarta.validation.constraints.NotNull;

public record RoomRequestDTO(
        @NotNull(message = "Please insert the room length") Float length,
        @NotNull(message = "Please insert the room width") Float width,
        @NotNull(message = "Please insert the property id") Integer propertyId
) {
}
