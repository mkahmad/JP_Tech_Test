package com.jpmorgon.test.TechTest.api;

import com.jpmorgon.test.TechTest.Stock;
import com.jpmorgon.test.TechTest.Trade;
import com.jpmorgon.test.TechTest.TransactionType;

/**
 * 
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public interface StockMarketService {
	public double dividened(Stock stock, double price);
	public double peRatio(Stock stock, double price);
	public Trade record(Stock stock, long timestamp, int qty, TransactionType txType, double tradePrice);
	public double volumeWeightedStockPrice(Stock stock, int minutes);
	public double geometricMean();
}
