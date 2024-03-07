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
    public Imovel save(Imovel obj) {
        return imovelService.save(obj);
    }

    @Override
    public Imovel update(int id, Imovel obj) {
        return imovelService.update(id, obj);
    }

    @Override
    public String deleteById(int id) {
        return imovelService.deleteById(id);
    }
}
