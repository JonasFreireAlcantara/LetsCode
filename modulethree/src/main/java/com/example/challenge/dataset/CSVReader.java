package com.example.challenge.dataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.challenge.sale.Sale;
import com.example.challenge.sale.SaleBuilder;

public class CSVReader {

    public List<Optional<Sale>> load(Path path, boolean ignoreFirstLine) throws IOException {
        List<String> lines = Files.readAllLines(path);
        if (ignoreFirstLine) {
            lines.remove(0);
        }

        return lines.stream()
                .map(this::loadSaleByLine)
                .collect(Collectors.toList());
    }

    private Optional<Sale> loadSaleByLine(String line) {
        Optional<Sale> result;

        if (line.equals("null")) {
            result = Optional.empty();
        } else {
            String[] elements = line.split(",");
            Sale sale = new SaleBuilder()
                    .setDate(elements[0])
                    .setProductName(elements[1])
                    .setValue(elements[2])
                    .build();
            result = Optional.of(sale);
        }

        return result;
    }
}