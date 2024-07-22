package com.ippf.havendac.business.services;

import com.ippf.havendac.model.ENUM.RoomType;
import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.model.entities.Role;
import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.model.entities.User;
import com.ippf.havendac.model.repository.RoleRepository;
import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import com.ippf.havendac.presentation.DTO.request.UserRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConverterService {
    private PropertyServiceImpl propertyService;
    private RoleRepository roleRepository;

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

    public User dtoToUser(UserRequestDTO userRequestDTO) {
        List<Role> roles = roleRepository.findAllById(userRequestDTO.roles());
        User user = new User(userRequestDTO);
        user.setRoles(roles);
        return user;

    }

}
