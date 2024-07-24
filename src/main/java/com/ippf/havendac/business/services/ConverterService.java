package com.ippf.havendac.business.services;

import com.ippf.havendac.model.ENUM.RoomType;
import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConverterService {
    private PropertyServiceImpl propertyService;

    public Room dtoToRoom(RoomRequestDTO roomRequestDTO) {
        Property property = propertyService.findById(roomRequestDTO.propertyId());
        Room room = new Room(roomRequestDTO);
        room.setProperty(property);
        return room;
    }

    public Room filterToRoom(Integer roomId, Float area, RoomType roomType, Integer propertyId) {
        if (propertyId == null) return new Room(roomId, area, roomType, null);
        Property property = propertyService.findById(propertyId);
        return new Room(roomId, area, roomType, property);
    }

}
