package com.ippf.havendac.controllers;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface GenericCRUDController<T extends HavenEntity> {
    public T getById(int id);

    public List<T> getAll();

    public T save(T obj);

    public T update(int id, T obj);

    public String deleteById(int id);
}
