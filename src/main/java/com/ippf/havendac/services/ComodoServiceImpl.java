package com.ippf.havendac.services;

import com.ippf.havendac.entities.Comodo;
import com.ippf.havendac.repository.ComodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComodoServiceImpl implements GenericCRUDService<Comodo> {

    private final ComodoRepository comodoRepository;

    @Override
    public Comodo findById(int id) {
        return comodoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cômodo com id " + id + " não encontrado"));
    }

    @Override
    public List<Comodo> findAll() {
        return comodoRepository.findAll();
    }

    @Override
    public Comodo save(Comodo obj) {
        float area = obj.getComprimento() * obj.getLargura();
        obj.setArea(area);
        return comodoRepository.save(obj);
    }

    @Override
    public Comodo update(int id, Comodo obj) {
        findById(id);
        return comodoRepository.save(obj);
    }

    @Override
    public String deleteById(int id) {
        findById(id);
        comodoRepository.deleteById(id);
        return "Cômodo com id " + id + " deletado com sucesso";
    }
}
