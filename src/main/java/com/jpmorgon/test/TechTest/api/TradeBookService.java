package com.jpmorgon.test.TechTest.api;

import java.util.List;

import com.jpmorgon.test.TechTest.Stock;
import com.jpmorgon.test.TechTest.Trade;
/**
 * 
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public interface TradeBookService {
	public void addTrdae(Trade trade);
	public List<Trade> getAllTrades();
	public List<Trade> getStockTrades(Stock stock);
}
