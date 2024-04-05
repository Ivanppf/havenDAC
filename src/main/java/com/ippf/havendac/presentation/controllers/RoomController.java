package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.model.ENUM.RoomType;
import com.ippf.havendac.presentation.DTO.request.RoomRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomController {
    ResponseEntity find(
            Integer roomId,
            Float area,
            RoomType roomType,
            Integer propertyId);

    ResponseEntity save(@Valid RoomRequestDTO obj);

    ResponseEntity saveAll(@Valid List<RoomRequestDTO> objList);

    ResponseEntity update(int id, @Valid RoomRequestDTO obj);

    ResponseEntity deleteById(int id);
}
