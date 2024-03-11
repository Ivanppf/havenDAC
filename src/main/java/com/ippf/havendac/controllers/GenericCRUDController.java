package com.ippf.havendac.controllers;

import com.ippf.havendac.entities.HavenEntity;

import java.util.List;

public interface GenericCRUDController<T extends HavenEntity> {
    T getById(int id);

    List<T> getAll();

    String save(T obj);

    String update(int id, T obj);

    String deleteById(int id);
}
