package com.jpmorgon.test.TechTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jpmorgon.test.TechTest.api.StockMarketService;
import com.jpmorgon.test.TechTest.api.impl.StockMarketServiceImpl;

/**
 * This is simplest implementation
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public class StockMarketAPITest {
	
	private static List<Stock> stocks = new ArrayList<Stock>();
	private StockMarketService stockMarketAPI;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Stock stock1 = new Stock("TEA", StockType.COMMON, 0, 0, 100);
		Stock stock2 = new Stock("POP", StockType.COMMON, 8, 0, 100);
		Stock stock3 = new Stock("ALE", StockType.COMMON, 23, 0, 60);
		Stock stock4 = new Stock("GIN", StockType.PREFERRED, 8, 2, 100);
		Stock stock5 = new Stock("JOE", StockType.COMMON, 13, 0, 250);
		
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		stocks.add(stock4);
		stocks.add(stock5);
		
		
	}

	@Before
	public void setUp() throws Exception {
		stockMarketAPI = new StockMarketServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void calculateDividendYieldTest(){
		
		double dy = 0.0d;
		for (Stock stock : stocks){
			dy = stockMarketAPI.dividened(stock,(long) (Math.random() * 100d));
			System.out.println("Dividend Yield for Stock ("+ stock.getSymbol() +") : " + dy);
		}
	}
	
	
	@Test
	public void calculatePERatioTest(){
		double dy = 0.0d;
		for (Stock stock : stocks){
			dy = stockMarketAPI.peRatio(stock,(long) (Math.random() * 100d));
			System.out.println("P/E Ratio for Stock ("+ stock.getSymbol() +") : " + dy);
		}
	}
	
	@Test
	public void recordTradeTest(){
		for (int i = 0; i < 5; i++){
			for (Stock stock : stocks){
				stockMarketAPI.record(stock, System.currentTimeMillis(), 10, (i % 2 == 0 ? TransactionType.BUY : TransactionType.SELL),(long) Math.random() * 50);
			}
		}
		
	}
	
	@Test
	public void calculeVolumeWeightedStockPriceTest(){
		// Record trades
		long timestamp = System.currentTimeMillis();
		Stock stockRandom = stocks.get( (int) ( Math.random() * 10.0d) % stocks.size());
		
		for (int i = 0; i < 20; i++){
			timestamp -= ((2.5 * i) * 1000);
			int qty = (int) (Math.random() * (10 * i)) % 10;
			for(Stock stock : stocks){
				stockMarketAPI.record(stock, timestamp, qty, (i % 2 == 0 ? TransactionType.BUY : TransactionType.SELL), (long) ((Math.random() * 100) * i));
			}
		}
		// calculate
		double dy = stockMarketAPI.volumeWeightedStockPrice(stockRandom, 15); // 15 minutes
		System.out.println("Volume Weighted Stock ("+stockRandom.getSymbol()+")  Price for last (15 minutes) : " + dy);
	}
	
	@Test
	public void calculateGeometricMeanTest(){
		// Record trades
		long timestamp = System.currentTimeMillis();
		for (int i = 0; i < 20; i++){
			timestamp -= ((2.5 * i) * 1000);
			int qty = (int) (Math.random() * (10 * i)) % 5;
			stockMarketAPI.record(stocks.get( (i*10) % stocks.size()), timestamp, qty, (i % 2 == 0 ? TransactionType.BUY : TransactionType.SELL), (long) ((Math.random() * 100) * i));
		}
		
		double dy = stockMarketAPI.geometricMean();
		System.out.println("GBCE All Share Index : " + dy);
	}
	
}
