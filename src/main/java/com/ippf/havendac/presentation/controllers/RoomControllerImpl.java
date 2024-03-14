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
public class RoomControllerImpl implements RoomController {

    private final RoomServiceImpl roomService;
    private final ConverterService converterService;

    @GetMapping()
    public ResponseEntity find(
            @RequestParam(value = "roomId", required = false) Integer roomId,
            @RequestParam(value = "area", required = false) Float area,
            @RequestParam(value = "propertyId", required = false) Integer propertyId) {
        try {
            Room roomFilter = converterService.filterToRoom(roomId, area, propertyId);
            List<Room> rooms = roomService.find(roomFilter);
            return ResponseEntity.ok().body(rooms.stream().map(RoomResponseDTO::new));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @PostMapping
    public ResponseEntity save(@RequestBody RoomRequestDTO obj) {
        try {
            Room room = converterService.dtoToRoom(obj);
            room = roomService.save(room);
            return new ResponseEntity(new RoomResponseDTO(room), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody RoomRequestDTO obj) {
        try {
            Room room = converterService.dtoToRoom(obj);
            room.setId(id);
            room = roomService.save(room);
            return ResponseEntity.ok().body(new RoomResponseDTO(room));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id) {
        try {
            roomService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
