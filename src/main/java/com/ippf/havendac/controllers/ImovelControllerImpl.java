package com.ippf.havendac.controllers;

import com.ippf.havendac.entities.Imovel;
import com.ippf.havendac.services.ImovelServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class ImovelControllerImpl implements GenericCRUDController<Imovel> {

    private final ImovelServiceImpl imovelService;

    @Override
    public Imovel getById(int id) {
        return imovelService.findById(id);
    }

    @Override
    public List<Imovel> getAll() {
        return imovelService.findAll();
    }

    @Override
    public String save(Imovel obj) {
        imovelService.save(obj);
        return "Imovel com id " + obj.getId() + " cadastrado com sucesso";
    }

    @Override
    public String update(int id, Imovel obj) {
        imovelService.update(id, obj);
        return "Imovel com id " + id + " atualizado com sucesso";
    }

    @Override
    public String deleteById(int id) {
        imovelService.deleteById(id);
        return "Imovel com id " + id + " deletado com sucesso";
    }
}
