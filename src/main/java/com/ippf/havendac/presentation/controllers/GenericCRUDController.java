package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.presentation.DTO.request.RequestDTO;
import com.ippf.havendac.presentation.DTO.response.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericCRUDController<REQUEST extends RequestDTO, RESPONSE extends ResponseDTO> {
    ResponseEntity<RESPONSE> getById(int id);

    ResponseEntity<List<RESPONSE>> getAll();

    ResponseEntity<RESPONSE> save(REQUEST obj);

    ResponseEntity<String> update(int id, REQUEST obj);

    ResponseEntity<String> deleteById(int id);
}
