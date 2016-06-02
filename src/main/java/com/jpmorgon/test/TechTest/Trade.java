package com.jpmorgon.test.TechTest;

import java.io.Serializable;

/**
 * This is simplest implementation
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public class Trade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8231315880342621276L;
	
	private Stock stock;
	private long tradeTimestamp;
	private int sharesQuantity;
	private TransactionType transaction;
	private double tradedPrice;

	public Trade(Stock stock, long tradeTimestamp, int sharesQuantity,
			TransactionType transaction, double tradedPrice) {
		super();
		this.stock = stock;
		this.tradeTimestamp = tradeTimestamp;
		this.sharesQuantity = sharesQuantity;
		this.transaction = transaction;
		this.tradedPrice = tradedPrice;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public long getTradeTimestamp() {
		return tradeTimestamp;
	}

	public void setTradeTimestamp(long tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}

	public int getSharesQuantity() {
		return sharesQuantity;
	}

	public void setSharesQuantity(int sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}

	public TransactionType getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionType transaction) {
		this.transaction = transaction;
	}

	public double getTradedPrice() {
		return tradedPrice;
	}

	public void setTradedPrice(double tradedPrice) {
		this.tradedPrice = tradedPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result
				+ (int) (tradeTimestamp ^ (tradeTimestamp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (tradeTimestamp != other.tradeTimestamp)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trade [stock=" + stock + ", traderTimestamp=" + tradeTimestamp
				+ ", sharesQuantity=" + sharesQuantity + ", transaction="
				+ transaction + ", tradedPrice=" + tradedPrice + "]";
	}
}
