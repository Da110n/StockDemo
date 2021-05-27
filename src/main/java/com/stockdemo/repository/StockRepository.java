package com.stockdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.stockdemo.model.StockDatabase;
import com.stockdemo.yahoofinance.YahooFinanceConverter;

@Repository
public class StockRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public StockDatabase save(String stockCode) {
    	YahooFinanceConverter converter = new YahooFinanceConverter();
    	StockDatabase stockDatabase = converter.yahooFinanceToStockDatabase(stockCode);
        dynamoDBMapper.save(stockDatabase);
        return stockDatabase;
    }

    public StockDatabase getStockByCode(String stockCode) {
        return dynamoDBMapper.load(StockDatabase.class, stockCode);
    }

    public String delete(String stockCode) {
        StockDatabase stockDatabase = dynamoDBMapper.load(StockDatabase.class, stockCode);
        dynamoDBMapper.delete(stockDatabase);
        return "StockDatabase Deleted!";
    }

    public String update(String stockCode, StockDatabase stockDatabase) {
        dynamoDBMapper.save(stockDatabase,
                new DynamoDBSaveExpression()
        .withExpectedEntry("stockCode",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(stockCode)
                )));
        return stockCode;
    }
}
