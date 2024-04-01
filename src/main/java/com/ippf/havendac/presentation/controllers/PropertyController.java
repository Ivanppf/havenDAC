package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.presentation.DTO.request.PropertyRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropertyController {

    ResponseEntity find(
            Integer id,
            PropertyType type,
            Boolean isAvailable,
            Boolean isCountryside,
            Boolean hasSwimmingPool);

    ResponseEntity save(PropertyRequestDTO obj);

    ResponseEntity saveAll(List<PropertyRequestDTO> objList);

    ResponseEntity update(int id, PropertyRequestDTO obj);

    ResponseEntity deleteById(int id);
}
