package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.presentation.DTO.request.PropertyRequestDTO;
import org.springframework.http.ResponseEntity;

public interface PropertyController {

    ResponseEntity find(
            Integer id,
            PropertyType type,
            Boolean isAvailable,
            Boolean isCountryside,
            Boolean hasSwimmingPool);

    ResponseEntity save(PropertyRequestDTO obj);

    ResponseEntity update(int id, PropertyRequestDTO obj);

    ResponseEntity deleteById(int id);
}
