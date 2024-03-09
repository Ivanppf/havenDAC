package com.ippf.havendac.view;

import com.ippf.havendac.ENUM.TipoImovel;
import com.ippf.havendac.controllers.ImovelControllerImpl;
import com.ippf.havendac.entities.HavenEntity;
import com.ippf.havendac.entities.Imovel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MenuImovel implements Menu {

    private MyCustomIO myCustomIO;
    private ImovelControllerImpl imovelController;

    @Override
    public Imovel create() {
        myCustomIO.print("""
                Tipo do imóvel:
                1 - APARTAMENTO
                2 - CASA
                3 - QUARTO
                4 - CHALE
                5 - POUSADA
                6 - FAZENDA
                ->\s""");
        TipoImovel tipo = null;
        switch (myCustomIO.read()) {
            case "1" -> tipo = TipoImovel.APARTAMENTO;
            case "2" -> tipo = TipoImovel.CASA;
            case "3" -> tipo = TipoImovel.QUARTO;
            case "4" -> tipo = TipoImovel.CHALE;
            case "5" -> tipo = TipoImovel.POUSADA;
            case "6" -> tipo = TipoImovel.FAZENDA;
        }
        myCustomIO.print("Descrição do imóvel: ");
        String descricao = myCustomIO.read();
        myCustomIO.print("O imóvel está disponível no momento? ");
        boolean disponivel = Boolean.parseBoolean(myCustomIO.read());
        myCustomIO.print("O imóvel está localizado em zona rural? ");
        boolean zonaRural = Boolean.parseBoolean(myCustomIO.read());
        myCustomIO.print("O imóvel possui piscina? ");
        boolean piscina = Boolean.parseBoolean(myCustomIO.read());
        return new Imovel(descricao, tipo, disponivel, zonaRural, piscina);
    }

    @Override
    public List<HavenEntity> getAll() {
        return imovelController.getAll().stream().map((item) -> (HavenEntity) item).toList();
    }

    @Override
    public void save() {
        imovelController.save(create());
    }

}
