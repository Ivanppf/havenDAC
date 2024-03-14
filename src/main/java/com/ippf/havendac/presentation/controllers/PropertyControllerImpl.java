package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.PropertyServiceImpl;
import com.ippf.havendac.model.ENUM.PropertyType;
import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.presentation.DTO.request.PropertyRequestDTO;
import com.ippf.havendac.presentation.DTO.response.PropertyResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@AllArgsConstructor
@RestController
@SessionScope
@RequestMapping("/properties")
public class PropertyControllerImpl implements PropertyController {

    private final PropertyServiceImpl propertyService;

    @GetMapping()
    public ResponseEntity find(
            @RequestParam(value = "propertyId", required = false) Integer id,
            @RequestParam(value = "type", required = false) PropertyType type,
            @RequestParam(value = "isAvailable", required = false) Boolean isAvailable,
            @RequestParam(value = "isCountryside", required = false) Boolean isCountryside,
            @RequestParam(value = "hasSwimmingPool", required = false) Boolean hasSwimmingPool) {
        try {
            Property propertyFilter = new Property(id, type, isAvailable, isCountryside, hasSwimmingPool);
            List<Property> property = propertyService.find(propertyFilter);
            return ResponseEntity.ok().body(property.stream().map(PropertyResponseDTO::new).toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @PostMapping
    public ResponseEntity save(@RequestBody PropertyRequestDTO obj) {
        try {
            Property property = new Property(obj);
            property = propertyService.save(property);
            return new ResponseEntity(new PropertyResponseDTO(property), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody PropertyRequestDTO obj) {
        try {
            Property property = new Property(obj);
            property.setId(id);
            property = propertyService.update(id, property);
            return ResponseEntity.ok().body(new PropertyResponseDTO(property));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id) {
        try {
            propertyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
