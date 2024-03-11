package com.ippf.havendac.view;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config implements CommandLineRunner {

    private final MenuComodo menuComodo;
    private final MenuImovel menuImovel;
    private final MyCustomIO myCustomIO;
    private Menu menu;


    public String showMenuEntidades() {
        String menuImovel = """

                1 - Imóvel
                2 - Cômodo
                S - Sair
                ->\s""";
        myCustomIO.print(menuImovel);
        return myCustomIO.read();
    }

    public void showMenuOpcoes() {
        boolean continua2 = true;
        while (continua2) {
            String menuImovel = """

                    1 - Cadastrar novo
                    2 - Listar todos
                    S - Voltar
                    ->\s""";
            myCustomIO.print(menuImovel);
            String resp = myCustomIO.read();
            switch (resp) {
                case "1" -> myCustomIO.print(menu.save());
                case "2" -> menu.getAll().forEach((item) -> myCustomIO.print(item.toString() + "\n"));
                case "S" -> continua2 = false;
            }
        }
    }

    @Override
    public void run(String... args) {
        boolean continua = true;
        while (continua) {
            try {
                String resp = showMenuEntidades();
                if (resp.equals("S")) {
                    continua = false;
                } else {
                    switch (resp) {
                        case "1" -> menu = menuImovel;
                        case "2" -> menu = menuComodo;
                    }
                    showMenuOpcoes();
                }
            } catch (Exception e) {
                myCustomIO.print(e.getMessage());
            }
        }
    }
}
