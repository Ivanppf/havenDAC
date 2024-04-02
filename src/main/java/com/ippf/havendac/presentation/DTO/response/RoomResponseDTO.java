package com.ippf.havendac.presentation.DTO.response;

import com.ippf.havendac.model.ENUM.RoomType;
import com.ippf.havendac.model.entities.Room;

public record RoomResponseDTO(
        Integer id,
        Float length,
        Float width,
        RoomType roomType,
        Float area,
        Integer propertyId
) {
    public RoomResponseDTO(Room room) {
        this(room.getId(), room.getLength(), room.getWidth(), room.getRoomType(), room.getArea(), room.getProperty().getId());
    }
}
