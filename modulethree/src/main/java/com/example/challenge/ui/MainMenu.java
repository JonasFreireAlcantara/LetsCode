package com.example.challenge.ui;

import java.util.Scanner;

public enum MainMenu {

    LISTAR_TUDO("Listar todas as vendas", 1),
    TOTAL_VENDAS("Total de vendas", 2),
    TOTAL_VENDAS_POR_MES("Total de vendas por mês", 3),
    TOTAL_VENDAS_POR_PRODUTO("Total de vendas por produto", 4),
    PRODUTO_MAIS_VENDIDO("Produto mais vendido", 5),
    PRODUTO_MENOS_VENDIDO("Produto menos vendido", 6),
    VENDA_MAIS_CARA("Venda mais cara", 7),
    VENDA_MAIS_BARATA("Venda mais barata", 8),
    PRECO_MEDIO_PRODUTOS_VENDIDOS("Preço médio dos produtos vendidos", 9),
    SAIR("Sair", 10);

    private static final Scanner SCANNER = new Scanner(System.in);

    private String description;
    private int option;

    private MainMenu(String description, int option) {
        this.description = description;
        this.option = option;
    }

    public String getDescription() {
        return description;
    }

    public int getOption() {
        return option;
    }

    private static void showMenuOptions() {
        System.out.println("*** Dataset Query System ***\n============================");

        for (MainMenu option : MainMenu.values()) {
            System.out.println(option.getOption() + ") " + option.getDescription());
        }
    }

    private static int getInputInteger() {
        System.out.print("Escolha uma opção: ");

        while (true) {
            try {
                int number = Integer.parseInt(SCANNER.nextLine());
                System.out.println();

                return number;
            } catch (NumberFormatException e) {
                printInvalidOption();
            }
        }
    }

    public static MainMenu getMainMenuOptionInput() {
        showMenuOptions();

        while (true) {
            int choosenOption = getInputInteger();

            for (MainMenu option : MainMenu.values()) {
                if (option.getOption() == choosenOption) {
                    return option;
                }
            }

            printInvalidOption();
        }
    }

    private static void printInvalidOption() {
        System.out.println("Opção Inválida\nTente novamente\n\n");
    }

}
