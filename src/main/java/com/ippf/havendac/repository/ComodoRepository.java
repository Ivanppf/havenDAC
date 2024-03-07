package com.ippf.havendac.repository;

import com.ippf.havendac.entities.Comodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComodoRepository extends JpaRepository<Comodo, Integer> {
}
