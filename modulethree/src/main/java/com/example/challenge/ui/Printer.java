package com.example.challenge.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.example.challenge.sale.Sale;

public class Printer {

    public void listAll(List<Sale> sales) {
        System.out.println("Todas as Vendas\n\nData       | Valor      | Produto\n-------------------------------");

        for (Sale sale : sales) {
            String dateString = sale.getDate().map(date -> date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .orElse("----");
            String productString = sale.getProductName().orElse("Não definido");
            Double value = sale.getValue().orElse(0.0);

            System.out.printf("%-10s | R$%-7.2f | %s\n", dateString, value, productString);
        }

    }

    public void printSalesAmount(Long salesAmount) {
        System.out.println("Foram realizadas ao todo " + salesAmount + " vendas.");
    }

    public void printSalesAmountByMonth(Map<LocalDate, Long> salesAmountByMonth) {
        System.out.println("Quantidade de vendas por Mês:\n");
        System.out.println("Quantidade | Mês\n----------------------");

        salesAmountByMonth.forEach(
                (date, amount) -> System.out.printf(
                        "%-10s | %s\n",
                        amount,
                        date.format(DateTimeFormatter.ofPattern("MM/yyyy"))));
    }

    public void printSalesAmountByProduct(Map<String, Long> salesAmountByProduct) {
        System.out.println("Quantidade de vendas por Produto:\n");
        System.out.println("Quantidade | Produto\n----------------------");

        salesAmountByProduct.forEach(
                (product, amount) -> System.out.printf(
                        "%-10s | %s\n",
                        amount,
                        product));
    }

    public void printAveragePriceOfSales(Double averagePriceOfSales) {
        System.out.printf("O preço médio de todas as vendas foi de R$%.2f.\n", averagePriceOfSales);
    }

    public void printBestSellingProduct(String bestSellingProduct) {
        System.out.println("O produto mais vendido foi: " + bestSellingProduct + ".");
    }

    public void printLeastSoldProduct(String leastSoldProduct) {
        System.out.println("O produto menos vendido foi: " + leastSoldProduct + ".");
    }

    public void printMostExpensiveSale(Sale mostExpensiveSale) {
        String dateString = mostExpensiveSale.getDate()
                .map(date -> date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).orElse("----");
        String productString = mostExpensiveSale.getProductName().orElse("Não definido");
        Double value = mostExpensiveSale.getValue().orElse(0.0);

        System.out.printf("A venda de maior valor foi do produto \"%s\", realizada no dia %-10s e de valor R$%.2f.\n",
                productString, dateString, value);
    }

    public void printMostCheaperSale(Sale mostCheaperSale) {
        String dateString = mostCheaperSale.getDate()
                .map(date -> date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).orElse("----");
        String productString = mostCheaperSale.getProductName().orElse("Não definido");
        Double value = mostCheaperSale.getValue().orElse(0.0);

        System.out.printf("A venda mais barata foi do produto \"%s\", realizada no dia %-10s e de valor R$%.2f.\n",
                productString, dateString, value);
    }

    public void lineSeparator() {
        System.out.println("\n------------------------\n");
    }

}
