package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.ConverterService;
import com.ippf.havendac.business.services.RoomServiceImpl;
import com.ippf.havendac.model.entities.Room;
import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import com.ippf.havendac.presentation.DTO.response.RoomResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomControllerImpl implements GenericCRUDController<RoomRequestDTO, RoomResponseDTO> {

    private final RoomServiceImpl roomService;
    private final ConverterService converterService;

    @Override
    @GetMapping("{id}")
    public ResponseEntity<RoomResponseDTO> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(new RoomResponseDTO(roomService.findById(id)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RoomResponseDTO>> getAll() {
        return ResponseEntity.ok().body(roomService.findAll().stream().map(RoomResponseDTO::new).toList());
    }

    @Override
    @PostMapping
    public ResponseEntity<RoomResponseDTO> save(@RequestBody RoomRequestDTO obj) {
        Room room = converterService.dtoToRoom(obj);
        roomService.save(room);
        return new ResponseEntity(new RoomResponseDTO(room), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody RoomRequestDTO obj) {
        Room room = converterService.dtoToRoom(obj);
        room.setId(id);
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
