package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.presentation.DTO.RoomDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConverterService {
    private PropertyServiceImpl propertyService;

    public Room dtoToRoom(RoomDTO roomDTO) {
        Property property = propertyService.findById(roomDTO.propertyId());
        Room room = new Room(roomDTO);
        room.setProperty(property);
        return room;
    }

}
