package com.example.challenge.operation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.challenge.sale.Sale;

public class GrouperByProduct {

    protected GrouperByProduct() { }

    protected Map<String, List<Sale>> group(Stream<Sale> stream) {
        return stream.collect(
            Collectors.groupingBy(
                sale -> sale.getProductName().orElse("Não definido"),
                Collectors.toList()
            )
        );
    }

}
