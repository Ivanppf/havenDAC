package com.ippf.havendac.business.services;


import com.ippf.havendac.model.entities.Property;
import com.ippf.havendac.model.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public Property findById(int id) {
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property with id " + id + " not found"));
    }

    @Override
    public List<Property> find(Property propertyFilter) {
        Example example = Example.of(propertyFilter,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return propertyRepository.findAll(example);
    }

    @Override
    public Property save(Property obj) {
        return propertyRepository.save(obj);
    }

    @Override
    public Property update(int id, Property obj) {
        existsById(id);
        return propertyRepository.save(obj);
    }

    @Override
    public void deleteById(int id) {
        existsById(id);
        propertyRepository.deleteById(id);
    }

    @Override
    public void existsById(int id) {
        if (!propertyRepository.existsById(id)) {
            throw new RuntimeException("Property with id " + id + " not found");
        }
    }

}
