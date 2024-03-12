package com.ippf.havendac.services;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface GenericCRUDService<T extends HavenEntity> {

    T findById(int id);

    List<T> findAll();

    void save(T obj);

    void update(int id, T obj);

    void deleteById(int id);

}
