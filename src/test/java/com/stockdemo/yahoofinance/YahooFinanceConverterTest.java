package com.stockdemo.yahoofinance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.stockdemo.model.StockDatabase;

class YahooFinanceConverterTest {

	@Test
	void testYahooFinanceToStockDatabase() {
		YahooFinanceConverter converter = new YahooFinanceConverter(); 		
		StockDatabase yahooStock = converter.yahooFinanceToStockDatabase("MSFT");
		assertEquals("Microsoft Corporation", yahooStock.getStockName());
		assertEquals("MSFT", yahooStock.getStockCode());
	}

}
