package com.example.challenge.ui;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.challenge.dataset.CSVReader;
import com.example.challenge.operation.OperationFacade;
import com.example.challenge.sale.Sale;

public class Application {

    private static final String FILE_PATH = "src/main/java/resources/data.txt";

    private OperationFacade operationFacade;
    private CSVReader csvReader;
    private List<Sale> sales;
    private Printer printer;

    public Application(CSVReader csvReader) throws IOException {
        operationFacade = OperationFacade.getInstance();

        Path path = Paths.get(FILE_PATH);
        this.sales = this.loadSalesFromCSV(path);

        this.printer = new Printer();
    }

    public List<Sale> loadSalesFromCSV(Path path) throws IOException {
        return this.csvReader.load(path, true).stream()
                .filter(optionalSale -> optionalSale.isPresent())
                .map(optionalSale -> optionalSale.get())
                .collect(Collectors.toList());
    }

    public void execute() {
        while (true) {
            MainMenu chosenOption = MainMenu.getMainMenuOptionInput();

            if (chosenOption == MainMenu.SAIR) {
                System.out.println("\nSaindo ...\n");
                break;
            }

            this.executeOperationAccordingChosenOption(chosenOption);

            this.printer.lineSeparator();
        }

    }

    private void executeOperationAccordingChosenOption(MainMenu chosenOption) {
        switch (chosenOption) {
            case LISTAR_TUDO:
                this.printer.listAll(this.sales);
                break;
            case TOTAL_VENDAS:
                Long salesAmount = operationFacade.salesAmount(this.sales.stream());
                this.printer.printSalesAmount(salesAmount);
                break;
            case TOTAL_VENDAS_POR_MES:
                Map<LocalDate, Long> salesAmountByMonth = operationFacade.salesAmountByMonth(this.sales.stream());
                this.printer.printSalesAmountByMonth(salesAmountByMonth);
                break;
            case TOTAL_VENDAS_POR_PRODUTO:
                Map<String, Long> salesAmountByProduct = operationFacade.salesAmountByProduct(this.sales.stream());
                this.printer.printSalesAmountByProduct(salesAmountByProduct);
                break;
            case PRECO_MEDIO_PRODUTOS_VENDIDOS:
                Double averagePriceOfSales = operationFacade.averagePriceOfSales(this.sales.stream());
                this.printer.printAveragePriceOfSales(averagePriceOfSales);
                break;
            case PRODUTO_MAIS_VENDIDO:
                String bestSellingProduct = operationFacade.bestSellingProduct(this.sales.stream());
                this.printer.printBestSellingProduct(bestSellingProduct);
                break;
            case PRODUTO_MENOS_VENDIDO:
                String leastSoldProduct = operationFacade.leastSoldProduct(this.sales.stream());
                this.printer.printLeastSoldProduct(leastSoldProduct);
                break;
            case VENDA_MAIS_CARA:
                Sale mostExpensiveSale = operationFacade.mostExpensiveSale(this.sales.stream());
                this.printer.printMostExpensiveSale(mostExpensiveSale);
                break;
            case VENDA_MAIS_BARATA:
                Sale mostCheaperSale = operationFacade.mostCheaperSale(this.sales.stream());
                this.printer.printMostCheaperSale(mostCheaperSale);
                break;
            default:
                throw new IllegalArgumentException("Invalid option");
        }
    }

}
