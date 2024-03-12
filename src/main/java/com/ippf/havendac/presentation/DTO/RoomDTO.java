package com.ippf.havendac.presentation.DTO;

import com.ippf.havendac.model.entities.Room;
import jakarta.validation.constraints.NotNull;

public record RoomDTO(
        @NotNull(message = "Please insert the room length") float length,
        @NotNull(message = "Please insert the room width") float width,
        @NotNull(message = "Please insert the property id") int propertyId
) implements DTO {
    public RoomDTO(Room room) {
        this(room.getLength(), room.getWidth(), room.getId());
    }
}
