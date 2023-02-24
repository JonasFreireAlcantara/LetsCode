package com.example.challenge.operation;

import java.time.LocalDate;
import java.util.stream.Stream;

import com.example.challenge.sale.Sale;


public class DateFilter  {

    protected DateFilter() { }

    private boolean isBetween(LocalDate seek, LocalDate startInclusive, LocalDate endInclusive) {
        return seek.compareTo(startInclusive) >= 0 && seek.compareTo(endInclusive) <= 0;
    }

    protected Stream<Sale> filterByDate(Stream<Sale> stream, LocalDate startInclusive, LocalDate endInclusive) {
        return stream
                .filter(sale -> sale.getDate()
                        .filter(
                                date -> isBetween(date, startInclusive, endInclusive)
                        ).isPresent()
                );
    }

}
