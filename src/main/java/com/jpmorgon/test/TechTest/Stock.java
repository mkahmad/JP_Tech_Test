package com.jpmorgon.test.TechTest;

import java.io.Serializable;

/**
 * This is simplest implementation
 * @author Kamran Ahmad Mirza
 * @email kamranahmad786@hotmail.com
 *
 */
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 692195509289450831L;

	public Stock(String symbol, StockType type, double lastDividend,
			double fixedDividend, int parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	private String symbol;
	private StockType type;
	private Double lastDividend;
	private Double fixedDividend;
	private Integer parValue;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public StockType getType() {
		return type;
	}

	public void setType(StockType type) {
		this.type = type;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Integer getParValue() {
		return parValue;
	}

	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Stock other = (Stock) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", type=" + type + ", lastDividend="
				+ lastDividend + ", fixedDividend=" + fixedDividend
				+ ", parValue=" + parValue + "]";
	}

}
