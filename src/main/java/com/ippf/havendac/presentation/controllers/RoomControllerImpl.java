package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.ConverterService;
import com.ippf.havendac.business.services.RoomServiceImpl;
import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.presentation.DTO.RoomDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomControllerImpl implements GenericCRUDController<RoomDTO> {

    private final RoomServiceImpl roomService;
    private final ConverterService converterService;

    @Override
    @GetMapping("{id}")
    public ResponseEntity<RoomDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(new RoomDTO(roomService.findById(id)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAll() {
        return ResponseEntity.ok().body(roomService.findAll().stream().map(RoomDTO::new).toList());
    }

    @Override
    @PostMapping
    public ResponseEntity<String> save(@RequestBody RoomDTO obj) {
        Room room = converterService.dtoToRoom(obj);
        roomService.save(room);
        return ResponseEntity.ok().body("Room registered successfully");
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody RoomDTO obj) {
        Room room = converterService.dtoToRoom(obj);
        roomService.save(room);
        return ResponseEntity.ok().body("Room with id " + id + " updated successfully");
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        roomService.deleteById(id);
        return ResponseEntity.ok().body("Room with id " + id + " deleted successfully");
    }
}
