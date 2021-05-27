package com.stockdemo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockdemo.model.StockDatabase;
import com.stockdemo.repository.StockRepository;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
public class StockController {

    @Autowired
    private StockRepository stockRepository;
    
    @PostMapping("/stock/{code}")
    public StockDatabase saveStock(@PathVariable("code") String stockCode) {
        return stockRepository.save(stockCode);
    }

    @GetMapping("/stock/{code}")
    public StockDatabase getStock(@PathVariable("code") String stockCode) {
        return stockRepository.getStockByCode(stockCode);
    }

    @DeleteMapping("/stock/{code}")
    public String deleteStock(@PathVariable("code") String stockCode) {
        return  stockRepository.delete(stockCode);
    }

    @PutMapping("/stock/{code}")
    public String updateStock(@PathVariable("code") String stockCode) throws IOException {
    	Stock stock = YahooFinance.get(stockCode);
    	StockDatabase stockDatabase = new StockDatabase();
    	stockDatabase.setStockCode(stockCode);
    	stockDatabase.setStockName(stock.getName());
    	stockDatabase.setCurrentPrice(stock.getQuote().getPrice().toString());
    	stockDatabase.setQuoteHistory(stock.getHistory().toString());
    	return stockRepository.update(stockCode,stockDatabase);
    }
}
