package com.example.challenge.sale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class SaleBuilder {

    private Sale sale;

    public SaleBuilder() {
        this.sale = new Sale();
    }

    public SaleBuilder setDate(String date) {
        Optional<LocalDate> optionalLocalDate;
        try {

            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            optionalLocalDate = Optional.of(localDate);
        } catch (DateTimeParseException e) {
            optionalLocalDate = Optional.empty();
        }
        Optional.ofNullable(null);

        this.sale.setDate(optionalLocalDate);

        return this;
    }

    public SaleBuilder setProductName(String name) {
        Optional<String> optionalName = Optional.ofNullable(name)
                .filter(n -> !n.equals("null"));

        this.sale.setProductName(optionalName);

        return this;
    }

    public SaleBuilder setValue(String value) {
        Optional<Double> optionalDouble;
        try {
            Double doubleValue = Double.valueOf(value);
            optionalDouble = Optional.of(doubleValue);
        } catch (NumberFormatException e) {
            optionalDouble = Optional.empty();
        }
        this.sale.setValue(optionalDouble);

        return this;
    }

    public Sale build() {
        return this.sale;
    }

}
