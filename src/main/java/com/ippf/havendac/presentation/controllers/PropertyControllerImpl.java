package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.PropertyServiceImpl;
import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.presentation.DTO.request.PropertyRequestDTO;
import com.ippf.havendac.presentation.DTO.response.PropertyResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyControllerImpl implements GenericCRUDController<PropertyRequestDTO, PropertyResponseDTO> {

    private final PropertyServiceImpl propertyService;

    @Override
    @GetMapping("{id}")
    public ResponseEntity<PropertyResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(new PropertyResponseDTO(propertyService.findById(id)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PropertyResponseDTO>> getAll() {
        return ResponseEntity.ok().body(propertyService.findAll().stream().map(PropertyResponseDTO::new).toList());
    }

    @Override
    @PostMapping
    public ResponseEntity<PropertyResponseDTO> save(@RequestBody PropertyRequestDTO obj) {
        Property property = new Property(obj);
        propertyService.save(property);
        return new ResponseEntity(new PropertyResponseDTO(property), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody PropertyRequestDTO obj) {
        Property property = new Property(obj);
        property.setId(id);
        propertyService.update(id, property);
        return ResponseEntity.ok().body("Property with id " + id + " updated successfully");
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        propertyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
