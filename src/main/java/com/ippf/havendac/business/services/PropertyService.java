package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.Property;

import java.util.List;

public interface PropertyService {
    Property findById(int id);

    List<Property> find(Property propertyFilter);

    void save(Property obj);

    void update(int id, Property obj);

    void deleteById(int id);

    void existsById(int id);
}
