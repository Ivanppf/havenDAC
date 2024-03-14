package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import org.springframework.http.ResponseEntity;

public interface RoomController {
    ResponseEntity find(
            Integer roomId,
            Float area,
            Integer propertyId);

    ResponseEntity save(RoomRequestDTO obj);

    ResponseEntity update(int id, RoomRequestDTO obj);

    ResponseEntity deleteById(int id);
}
