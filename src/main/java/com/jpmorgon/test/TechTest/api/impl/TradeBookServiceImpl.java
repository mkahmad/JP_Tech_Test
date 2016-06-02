package com.jpmorgon.test.TechTest.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgon.test.TechTest.Stock;
import com.jpmorgon.test.TechTest.Trade;
import com.jpmorgon.test.TechTest.api.TradeBookService;
/**
 * This is simplest implementation
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public class TradeBookServiceImpl implements TradeBookService{

	private static List<Trade> tradeBook = new ArrayList<Trade>();
	
	public void addTrdae(Trade trade) {
		// An implementation of stock control can be added at this point
		// Transaction Type of a trade can be cased
		//      to maintain preserved quantity if require
		// Not implementation under this solution -- Real time may have this solution 
		// missing domain knowledge
		tradeBook.add(trade);
	}

	public List<Trade> getAllTrades() {
		return tradeBook;
	}
	
	public List<Trade> getStockTrades(Stock stock){
		List<Trade> stockTrades = new ArrayList<Trade>();
		for (Trade t : tradeBook){
			if (t.getStock().equals(stock)){
				stockTrades.add(t);
			}
		}
		return stockTrades;
	}

}
