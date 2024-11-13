package com.example.demo.finapi.controller;

import com.example.demo.finapi.service.StockFetcherService;
import com.example.demo.finapi.service.StockPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class StockController {

    @Autowired
    private StockFetcherService stockFetcherService;

    @Autowired
    private StockPredictionService stockPredictionService;

    // Endpoint for stock data in a table
    @GetMapping("/stock-table")
    public String getStockTable(Model model) {
        Map<String, Object> stockData = stockFetcherService.fetchStockData("IBM");
        model.addAttribute("stockData", stockData);
        return "stock-table";
    }

    // Endpoint for stock data in a graph
    @GetMapping("/stock-graph")
    public String getStockGraph(Model model) {
        return "stock-graph";
    }

    // REST API endpoint to provide data to JavaScript for the graph
    @GetMapping("/api/stock-data")
    @ResponseBody
    public Map<String, Object> getStockData() {
        return stockFetcherService.fetchStockData("IBM");
    }
    @GetMapping("/stock-prediction")
    public String showStockPrediction(Model model) {
        Map<String, Object> stockData = stockFetcherService.fetchStockData("IBM");
        List<Double> predictedPrices = stockPredictionService.predictStockPrices(stockData, 50);
        model.addAttribute("predictedPrices", predictedPrices);
        return "stock-prediction";
    }


}
