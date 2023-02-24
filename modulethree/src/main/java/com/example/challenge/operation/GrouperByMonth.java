package com.example.challenge.operation;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.challenge.sale.Sale;

public class GrouperByMonth {

    protected GrouperByMonth() {
    }

    protected Map<LocalDate, List<Sale>> group(Stream<Sale> stream) {
        return stream
                .filter(sale -> sale.getDate().isPresent())
                .collect(
                        Collectors.groupingBy(
                                sale -> sale.getDate()
                                        .map(date -> LocalDate.of(date.getYear(), date.getMonthValue(), 1)).get()));
    }

}
