package com.example.challenge.operation;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.challenge.sale.Sale;

public class StatisticalCalculator {

    private GrouperByProduct grouperByProduct;
    private GrouperByMonth grouperByMonth;

    protected StatisticalCalculator(GrouperByProduct grouperByProduct, GrouperByMonth grouperByMonth) {
        this.grouperByProduct = grouperByProduct;
        this.grouperByMonth = grouperByMonth;
    }

    protected Double averagePriceOfSales(Stream<Sale> stream) {
        return stream
                .filter(sale -> sale.getValue().isPresent())
                .mapToDouble(sale -> sale.getValue().get())
                .average()
                .getAsDouble();
    }

    protected Sale mostExpensiveSale(Stream<Sale> stream) {
        return stream
                .max((sale1, sale2) -> Double.compare(
                    sale1.getValue().orElse(Double.NEGATIVE_INFINITY),
                    sale2.getValue().orElse(Double.NEGATIVE_INFINITY)
                ))
                .get();
    }

    protected Sale mostCheaperSale(Stream<Sale> stream) {
        return stream
                .min((sale1, sale2) -> Double.compare(
                    sale1.getValue().orElse(Double.POSITIVE_INFINITY),
                    sale2.getValue().orElse(Double.POSITIVE_INFINITY)
                ))
                .get();
    }

    protected String leastSoldProduct(Stream<Sale> stream) {
        Map<String, Long> salesAmountByProduct = this.salesAmountByProduct(stream);

        return salesAmountByProduct.entrySet()
                .stream()
                .min((entry1, entry2) -> Long.compare(entry1.getValue(), entry2.getValue()))
                .map(entry -> entry.getKey())
                .get();
    }

    protected String bestSellingProduct(Stream<Sale> stream) {
        Map<String, Long> salesAmountByProduct = this.salesAmountByProduct(stream);

        return salesAmountByProduct.entrySet()
                .stream()
                .max((entry1, entry2) -> Long.compare(entry1.getValue(), entry2.getValue()))
                .map(entry -> entry.getKey())
                .get();
    }

    protected Long salesAmount(Stream<Sale> stream) {
        return stream.count();
    }

    protected Map<String, Long> salesAmountByProduct(Stream<Sale> stream) {
        Map<String, List<Sale>> group = this.grouperByProduct.group(stream);

        return group.entrySet()
                .stream()
                .collect(
                    Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().stream().count()
                    )
                );
    }

    protected Map<LocalDate, Long> salesAmountByMonth(Stream<Sale> stream) {
        Map<LocalDate, List<Sale>> group = this.grouperByMonth.group(stream);

        return group.entrySet()
                .stream()
                .collect(
                    Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().stream().count()
                    )
                );
    }

    protected Map<String, Double> totalValueByProduct(Stream<Sale> stream) {
        Map<String, List<Sale>> group = this.grouperByProduct.group(stream);

        return group.entrySet()
                .stream()
                .collect(
                    Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().stream().mapToDouble(sale -> sale.getValue().orElse(0.0)).sum()
                    )
                );
    }

}
