package com.ippf.havendac.controllers;

import com.ippf.havendac.entities.Comodo;
import com.ippf.havendac.services.ComodoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ComodoControllerImpl implements GenericCRUDController<Comodo> {

    private final ComodoServiceImpl comodoService;


    @Override
    public Comodo getById(int id) {
        return comodoService.findById(id);
    }

    @Override
    public List<Comodo> getAll() {
        return comodoService.findAll();
    }

    @Override
    public Comodo save(Comodo obj) {
        return comodoService.save(obj);
    }

    @Override
    public Comodo update(int id, Comodo obj) {
        return comodoService.save(obj);
    }

    @Override
    public String deleteById(int id) {
        return comodoService.deleteById(id);
    }
}
