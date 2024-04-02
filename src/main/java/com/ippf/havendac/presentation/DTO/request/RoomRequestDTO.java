package com.ippf.havendac.presentation.DTO.request;

import com.ippf.havendac.model.ENUM.RoomType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RoomRequestDTO(
        @NotNull(message = "Please insert the room length") @Min(value = 1, message = "Length must be greater than zero") Float length,
        @NotNull(message = "Please insert the room width") @Min(value = 1, message = "Width must be greater than zero") Float width,
        @NotNull(message = "Please choose the room type") RoomType roomType,
        @NotNull(message = "Please insert the property id") Integer propertyId
) {
}
