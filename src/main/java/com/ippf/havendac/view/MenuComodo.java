package com.ippf.havendac.view;

import com.ippf.havendac.controllers.ComodoControllerImpl;
import com.ippf.havendac.controllers.ImovelControllerImpl;
import com.ippf.havendac.entities.Comodo;
import com.ippf.havendac.entities.Imovel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MenuComodo implements Menu<Comodo> {

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
    public List<Comodo> getAll() {
        return comodoController.getAll();
    }

    @Override
    public void save() {
        comodoController.save(create());
    }


}
