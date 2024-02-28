package com.ippf.havendac.configuration;

import com.ippf.havendac.ENUM.TipoImovel;
import com.ippf.havendac.Imovel;
import com.ippf.havendac.ImovelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class Config implements CommandLineRunner {

    private final ImovelRepository imovelRepository;
    Scanner input = new Scanner(System.in);
    String menu = """
                        
            1 - Adicionar novo imóvel
            2 - Listar imóveis
            S - sair
            ->\s""";

    public Config(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public String showMenu() {
        System.out.print(menu);
        return input.nextLine();
    }

    public Imovel createImovel() {
        String tiposImovel = """
                Tipo do imóvel:
                1 - APARTAMENTO
                2 - CASA
                3 - QUARTO
                4 - CHALE
                5 - POUSADA
                6 - FAZENDA
                ->\s""";
        System.out.print(tiposImovel);
        TipoImovel tipo = null;
        switch (input.nextLine()) {
            case "1" -> tipo = TipoImovel.APARTAMENTO;
            case "2" -> tipo = TipoImovel.CASA;
            case "3" -> tipo = TipoImovel.QUARTO;
            case "4" -> tipo = TipoImovel.CHALE;
            case "5" -> tipo = TipoImovel.POUSADA;
            case "6" -> tipo = TipoImovel.FAZENDA;
        }
        System.out.print("Descrição do imóvel: ");
        String descricao = input.nextLine();
        System.out.print("O imóvel está disponível no momento? ");
        boolean disponivel = input.nextBoolean();
        System.out.print("O imóvel está localizado em zona rural? ");
        boolean zonaRural = input.nextBoolean();
        System.out.print("O imóvel possui piscina? ");
        boolean piscina = input.nextBoolean();
        return new Imovel(descricao, tipo, disponivel, zonaRural, piscina);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean continua = true;
        while (continua) {
            try {
                String resp = showMenu();
                switch (resp) {
                    case "1" -> imovelRepository.save(createImovel());
                    case "2" -> imovelRepository.findAll().forEach(System.out::println);
                    case "S" -> continua = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
