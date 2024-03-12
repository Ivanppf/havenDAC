package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.PropertyServiceImpl;
import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.presentation.DTO.PropertyDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyControllerImpl implements GenericCRUDController<PropertyDTO> {

    private final PropertyServiceImpl propertyService;

    @Override
    @GetMapping("{id}")
    public ResponseEntity<PropertyDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(new PropertyDTO(propertyService.findById(id)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAll() {
        return ResponseEntity.ok().body(propertyService.findAll().stream().map(PropertyDTO::new).toList());
    }

    @Override
    @PostMapping
    public ResponseEntity<String> save(@RequestBody PropertyDTO obj) {
        propertyService.save(new Property(obj));
        return ResponseEntity.ok().body("Property registered successfully");
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody PropertyDTO obj) {
        propertyService.update(id, new Property(obj));
        return ResponseEntity.ok().body("Property with id " + id + " updated successfully");
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        propertyService.deleteById(id);
        return ResponseEntity.ok().body("Property with id " + id + " deleted successfully");
    }
}
