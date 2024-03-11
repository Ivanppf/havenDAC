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


    public void showMenuEntidades() {
        boolean continua = true;
        String menuEntidades = """

                1 - Imóvel
                2 - Cômodo
                S - Sair
                ->\s""";

        while (continua) {
            try {
                myCustomIO.print(menuEntidades);
                String resp = myCustomIO.read();
                switch (resp) {
                    case "1" -> menu = menuImovel;
                    case "2" -> menu = menuComodo;
                    case "S" -> continua = false;
                    default -> throw new RuntimeException("Opção inválida");
                }
                if (!resp.equals("S")) {
                    showMenuOpcoes();
                }
            } catch (Exception e) {
                myCustomIO.print(e.getMessage());
            }
        }
    }

    public void showMenuOpcoes() {
        boolean continua = true;
        String menuImovel = """

                1 - Cadastrar novo
                2 - Listar todos
                S - Voltar
                ->\s""";
        while (continua) {
            myCustomIO.print(menuImovel);
            String resp = myCustomIO.read();
            switch (resp) {
                case "1" -> myCustomIO.print(menu.save());
                case "2" -> menu.getAll().forEach((item) -> myCustomIO.print(item.toString() + "\n"));
                case "S" -> continua = false;
                default -> throw new RuntimeException("Opção inválida");
            }
        }
    }

    @Override
    public void run(String... args) {
        showMenuEntidades();
    }
}
