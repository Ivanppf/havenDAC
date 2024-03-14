package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> find(Room roomFilter);

    void save(Room obj);

    void update(int id, Room obj);

    void deleteById(int id);

    void existsById(int id);
}
