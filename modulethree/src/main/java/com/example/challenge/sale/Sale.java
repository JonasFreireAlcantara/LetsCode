package com.example.challenge.sale;

import java.time.LocalDate;
import java.util.Optional;

public class Sale {

    private Optional<LocalDate> date;
    private Optional<String> productName;
    private Optional<Double> value;

    protected Sale() {
    }

    public Optional<LocalDate> getDate() {
        return date;
    }

    protected void setDate(Optional<LocalDate> date) {
        this.date = date;
    }

    public Optional<String> getProductName() {
        return productName;
    }

    protected void setProductName(Optional<String> productName) {
        this.productName = productName;
    }

    public Optional<Double> getValue() {
        return value;
    }

    protected void setValue(Optional<Double> value) {
        this.value = value;
    }

}
