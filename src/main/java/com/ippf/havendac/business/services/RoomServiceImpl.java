package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.model.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements GenericCRUDService<Room> {

    private final RoomRepository roomRepository;

    @Override
    public Room findById(int id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room with id " + id + " not found"));
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void save(Room obj) {
        float area = obj.getLength() * obj.getWidth();
        obj.setArea(area);
        roomRepository.save(obj);
    }

    @Override
    public void update(int id, Room obj) {
        findById(id);
        roomRepository.save(obj);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        roomRepository.deleteById(id);
    }
}
