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
    public String save(Comodo obj) {
        comodoService.save(obj);
        return "Cômodo com id " + obj.getId() + " cadastrado com sucesso";
    }

    @Override
    public String update(int id, Comodo obj) {
        comodoService.save(obj);
        return "Cômodo com id " + id + " atualizado com sucesso";
    }

    @Override
    public String deleteById(int id) {
        comodoService.deleteById(id);
        return "Cômodo com id " + id + " deletado com sucesso";
    }
}
