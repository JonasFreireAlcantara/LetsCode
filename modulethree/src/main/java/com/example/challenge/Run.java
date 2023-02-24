package com.example.challenge;

import java.io.IOException;

import com.example.challenge.dataset.CSVReader;
import com.example.challenge.ui.Application;

public class Run {
    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader();

        Application application = new Application(csvReader);
        application.execute();
    }
}
