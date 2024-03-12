package com.ippf.havendac.model.repository;

import com.ippf.havendac.model.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
