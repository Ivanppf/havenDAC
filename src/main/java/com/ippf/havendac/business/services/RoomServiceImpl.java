package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.model.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void save(Room obj) {
        float area = obj.getLength() * obj.getWidth();
        obj.setArea(area);
        roomRepository.save(obj);
    }

    @Override
    public void update(int id, Room obj) {
        existsById(id);
        roomRepository.save(obj);
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
