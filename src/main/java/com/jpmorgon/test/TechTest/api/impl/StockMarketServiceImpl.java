package com.jpmorgon.test.TechTest.api.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgon.test.TechTest.Stock;
import com.jpmorgon.test.TechTest.Trade;
import com.jpmorgon.test.TechTest.TransactionType;
import com.jpmorgon.test.TechTest.api.StockMarketService;
import com.jpmorgon.test.TechTest.api.TradeBookService;
/**
 * This is simplest implementation
 * While in Real-time implementation
 * 		Custom Exception should be thrown 
 * 		Logger should be used
 * 		DI should be used such OSGI or Spring Framework for Service Implementation Injection
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public class StockMarketServiceImpl implements StockMarketService {

	private Logger LOG = Logger.getLogger(StockMarketServiceImpl.class.getName());
	
	/**
	 * Note * for simplicity I am assigning implementation od an instance directly
	 * Usually it is provided via Dependency Injection system
	 */
	private TradeBookService tradeBookService = new TradeBookServiceImpl();
	
	
	
	
	public double dividened(Stock stock, double price) {
		try {
			switch (stock.getType()) {
			case COMMON:
				return stock.getLastDividend() / price;
			case PREFERRED:
				return (stock.getFixedDividend() * stock.getParValue()) / price;
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
		}
		return 0;
	}

	public double peRatio(Stock stock, double price) {
		try {
			return price / stock.getLastDividend();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
		}
		return 0;
	}

	public double volumeWeightedStockPrice(Stock stock, int minutesOld) {
		if (stock == null) {
			LOG.log(Level.WARNING, "Stock should not be empty");
			return 0.0d;
		}
		long checkStamp =   System.currentTimeMillis() - (minutesOld * 60 * 1000); // min * sec * milies + current timestamp
		double dy = 0.0d;
		double dz = 0.0d;
		for (Trade t : tradeBookService.getStockTrades(stock)) {
			if (t.getTradeTimestamp() > checkStamp){
				dy += t.getTradedPrice() * t.getSharesQuantity();
				dz += t.getSharesQuantity();
			}
		}
		return dy / dz;
	}

	public double geometricMean() {
		List<Trade> tradeBook = tradeBookService.getAllTrades();
		double pow = (1.0d/(double)tradeBook.size());
		double product = product(tradeBook, 0);
		return Math.pow(product, pow) ;
	}
	
	public double product(List<Trade> trades, int position){
		if (position < trades.size()){
			return trades.get(position).getTradedPrice() * product(trades, ++position);
		} 
		return 1.0d;
	}

	public Trade record(Stock stock, long timestamp, int qty, TransactionType txType, double tradePrice) {
		if (qty <= 0 || tradePrice <= 0.0d) return null;
		Trade t =  new Trade(stock, timestamp, qty, txType, tradePrice);
		tradeBookService.addTrdae(t);
		return t;
	}

	

	
	
}
