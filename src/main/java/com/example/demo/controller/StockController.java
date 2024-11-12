package com.example.demo.controller;

import com.example.demo.service.StockFetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class StockController {

    @Autowired
    private StockFetcherService stockFetcherService;

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
}
