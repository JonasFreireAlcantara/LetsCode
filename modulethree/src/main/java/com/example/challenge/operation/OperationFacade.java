package com.example.challenge.operation;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import com.example.challenge.sale.Sale;

public class OperationFacade {

    private static OperationFacade instance;

    private StatisticalCalculator statisticalCalculator;

    private OperationFacade() {
        GrouperByProduct grouperByProduct = new GrouperByProduct();
        GrouperByMonth grouperByMonth = new GrouperByMonth();

        this.statisticalCalculator = new StatisticalCalculator(grouperByProduct, grouperByMonth);
    }

    public static OperationFacade getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OperationFacade();
        }

        return instance;
    }

    public Long salesAmount(Stream<Sale> stream) {
        return this.statisticalCalculator.salesAmount(stream);
    }

    public Map<LocalDate, Long> salesAmountByMonth(Stream<Sale> stream) {
        return this.statisticalCalculator.salesAmountByMonth(stream);
    }

    public Double averagePriceOfSales(Stream<Sale> stream) {
        return this.statisticalCalculator.averagePriceOfSales(stream);
    }

    public String bestSellingProduct(Stream<Sale> stream) {
        return this.statisticalCalculator.bestSellingProduct(stream);
    }

    public String leastSoldProduct(Stream<Sale> stream) {
        return this.statisticalCalculator.leastSoldProduct(stream);
    }

    public Sale mostExpensiveSale(Stream<Sale> stream) {
        return this.statisticalCalculator.mostExpensiveSale(stream);
    }

    public Sale mostCheaperSale(Stream<Sale> stream) {
        return this.statisticalCalculator.mostCheaperSale(stream);
    }

    public Map<String, Long> salesAmountByProduct(Stream<Sale> stream) {
        return this.statisticalCalculator.salesAmountByProduct(stream);
    }

}
