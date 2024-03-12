package com.ippf.havendac.view;

import com.ippf.havendac.controllers.ComodoControllerImpl;
import com.ippf.havendac.controllers.ImovelControllerImpl;
import com.ippf.havendac.entities.Comodo;
import com.ippf.havendac.entities.HavenEntity;
import com.ippf.havendac.entities.Imovel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class MenuComodo implements Menu {

    private MyCustomIO myCustomIO;
    private ImovelControllerImpl imovelController;
    private ComodoControllerImpl comodoController;

    @Override
    public Comodo create() {
        myCustomIO.print("Comprimento do cômodo em metros: ");
        float comprimento = Float.parseFloat(myCustomIO.read());
        myCustomIO.print("Largura do cômodo em metros: ");
        float largura = Float.parseFloat(myCustomIO.read());
        imovelController.getAll().forEach(imovel -> myCustomIO.print(imovel.toString() + "\n"));
        myCustomIO.print("Id do imóvel em que pertence: ");
        int idImovel = Integer.parseInt(myCustomIO.read());
        Imovel imovel = imovelController.getById(idImovel);
        return new Comodo(comprimento, largura, imovel);
    }

    @Override
    public List<HavenEntity> getAll() {
        return comodoController.getAll().stream().map((item) -> (HavenEntity) item).toList();
    }

    @Override
    public String save() {
        return comodoController.save(create());
    }


}
