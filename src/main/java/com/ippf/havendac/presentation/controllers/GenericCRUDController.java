package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.presentation.DTO.DTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericCRUDController<T extends DTO> {
    ResponseEntity<T> getById(int id);

    ResponseEntity<List<T>> getAll();

    ResponseEntity<String> save(T obj);

    ResponseEntity<String> update(int id, T obj);

    ResponseEntity<String> deleteById(int id);
}
