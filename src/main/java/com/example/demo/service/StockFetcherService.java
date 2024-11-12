package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class StockFetcherService {

    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY";
//    @Autowired
//    AzureKeyVaultService azureKeyVaultService;


    public Map<String, Object> fetchStockData(String symbol) {
//        String apiKey = azureKeyVaultService.getSecret("API-KEY");
        String apiKey= "JZR95VJH951RGR1T";
        String url = String.format("%s&symbol=%s&interval=5min&apikey=%s", BASE_URL, symbol, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && response.containsKey("Time Series (5min)")) {
            System.out.println("Stock data retrieved successfully for symbol: " + symbol);
        } else {
            System.out.println("Failed to retrieve data or unexpected response format.");
        }

        return response;
    }
}
