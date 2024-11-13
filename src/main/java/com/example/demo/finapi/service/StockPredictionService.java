package com.example.demo.finapi.service;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StockPredictionService {

    public List<Double> predictStockPrices(Map<String, Object> stockData, int numPredictions) {
        SimpleRegression regression = new SimpleRegression();
        Map<String, Object> timeSeries = (Map<String, Object>) stockData.get("Time Series (5min)");
        int index = 0;

        for (Map.Entry<String, Object> entry : timeSeries.entrySet()) {
            double price = Double.parseDouble(((Map<String, String>) entry.getValue()).get("1. open"));
            regression.addData(index++, price); // X = index, Y = open price
        }

        // Generate multiple predicted prices (next 'numPredictions' steps)
        List<Double> predictedPrices = new ArrayList<>();
        for (int i = 0; i < numPredictions; i++) {
            predictedPrices.add(regression.predict(index + i));  // Predict for the next 'numPredictions' indexes
        }

        return predictedPrices;
    }

}
