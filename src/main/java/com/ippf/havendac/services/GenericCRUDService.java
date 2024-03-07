package com.ippf.havendac.services;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface GenericCRUDService<T extends HavenEntity> {

    public T findById(int id);

    public List<T> findAll();

    public T save(T obj);

    public T update(int id, T obj);

    public String deleteById(int id);

}
