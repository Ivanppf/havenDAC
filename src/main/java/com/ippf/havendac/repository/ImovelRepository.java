package com.ippf.havendac.repository;

import com.ippf.havendac.entities.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}
