package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.RoomServiceImpl;
import com.ippf.havendac.model.entities.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class RoomControllerImpl implements GenericCRUDController<Room> {

    private final RoomServiceImpl roomService;

    @Override
    public Room getById(int id) {
        return roomService.findById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomService.findAll();
    }

    @Override
    public String save(Room obj) {
        roomService.save(obj);
        return "Room registered successfully";
    }

    @Override
    public String update(int id, Room obj) {
        roomService.save(obj);
        return "Room with id " + id + " updated successfully";
    }

    @Override
    public String deleteById(int id) {
        roomService.deleteById(id);
        return "Room with id " + id + " deleted successfully";
    }
}
