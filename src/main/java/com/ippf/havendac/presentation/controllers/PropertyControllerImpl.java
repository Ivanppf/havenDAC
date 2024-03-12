package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.PropertyServiceImpl;
import com.ippf.havendac.model.entities.Property;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class PropertyControllerImpl implements GenericCRUDController<Property> {

    private final PropertyServiceImpl propertyService;

    @Override
    public Property getById(int id) {
        return propertyService.findById(id);
    }

    @Override
    public List<Property> getAll() {
        return propertyService.findAll();
    }

    @Override
    public String save(Property obj) {
        propertyService.save(obj);
        return "Property registered successfully";
    }

    @Override
    public String update(int id, Property obj) {
        propertyService.update(id, obj);
        return "Property with id " + id + " updated successfully";
    }

    @Override
    public String deleteById(int id) {
        propertyService.deleteById(id);
        return "Property with id " + id + " deleted successfully";
    }
}
