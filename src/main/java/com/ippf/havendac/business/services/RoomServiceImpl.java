package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.model.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@SessionScope
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<Room> find(Room roomFilter) {
        Example example = Example.of(roomFilter,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return roomRepository.findAll(example);
    }

    @Override
    public Room save(Room obj) {
        float area = obj.getLength() * obj.getWidth();
        obj.setArea(area);
        return roomRepository.save(obj);
    }

    @Override
    public List<Room> saveAll(List<Room> obj) {
        List<Room> roomList = new ArrayList<>();
        obj.forEach(r -> {
            float area = r.getLength() * r.getWidth();
            r.setArea(area);
            roomList.add(r);
        });
        return roomRepository.saveAll(roomList);
    }

    @Override
    public Room update(int id, Room obj) {
        existsById(id);
        return roomRepository.save(obj);
    }

    @Override
    public void deleteById(int id) {
        existsById(id);
        roomRepository.deleteById(id);
    }

    @Override
    public void existsById(int id) {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room with id " + id + " not found");
        }
    }

}
