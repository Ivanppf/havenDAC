package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomController {
    ResponseEntity find(
            Integer roomId,
            Float area,
            Integer propertyId);

    ResponseEntity save(RoomRequestDTO obj);

    ResponseEntity saveAll(List<RoomRequestDTO> objList);

    ResponseEntity update(int id, RoomRequestDTO obj);

    ResponseEntity deleteById(int id);
}
