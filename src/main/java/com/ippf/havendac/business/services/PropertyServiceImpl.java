package com.ippf.havendac.business.services;


import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.model.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropertyServiceImpl implements GenericCRUDService<Property> {

    private final PropertyRepository propertyRepository;

    @Override
    public Property findById(int id) {
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property with id " + id + " not found"));
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public void save(Property obj) {
        propertyRepository.save(obj);
    }

    @Override
    public void update(int id, Property obj) {
        findById(id);
        propertyRepository.save(obj);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        propertyRepository.deleteById(id);

    }
}
