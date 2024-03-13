package com.ippf.havendac.presentation.DTO.response;

import com.ippf.havendac.model.entities.Room;

public record RoomResponseDTO(
        int id,
        float length,
        float width,
        int propertyId
) implements ResponseDTO {
    public RoomResponseDTO(Room room) {
        this(room.getId(), room.getLength(), room.getWidth(), room.getProperty().getId());
    }
}
