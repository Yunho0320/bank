package com.example.demo;

import com.example.demo.service.StockFetcherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class FinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinApiApplication.class, args);
		System.out.println("Success");
		StockFetcherService fetch = new StockFetcherService();
		Map<String, Object> response = fetch.fetchStockData("IBM");
	}
}
