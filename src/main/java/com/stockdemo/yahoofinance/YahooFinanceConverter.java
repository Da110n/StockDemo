package com.stockdemo.yahoofinance;

import java.io.IOException;

import com.stockdemo.model.StockDatabase;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class YahooFinanceConverter {
	
	public StockDatabase yahooFinanceToStockDatabase(String stockCode) {
		Stock stock;
		StockDatabase stockDatabase = new StockDatabase();
		try {
			stock = YahooFinance.get(stockCode);
	    	stockDatabase.setStockCode(stockCode);
	    	stockDatabase.setStockName(stock.getName());
	    	stockDatabase.setCurrentPrice(stock.getQuote().getPrice().toString());
	    	stockDatabase.setQuoteHistory(stock.getHistory().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stockDatabase;
	}

}
