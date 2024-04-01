package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Property;

import java.util.List;

public interface PropertyService {
    Property findById(int id) throws RuntimeException;

    List<Property> find(Property propertyFilter);

    Property save(Property obj);

    List<Property> saveAll(List<Property> propertyList);

    Property update(int id, Property obj);

    void deleteById(int id);

    void existsById(int id) throws RuntimeException;
}
