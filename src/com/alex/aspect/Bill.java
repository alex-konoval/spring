package com.alex.aspect;

import java.math.BigDecimal;

/**
 * Счет в котором отражена сумма, валюта и страна платежа
 *
 */
public class Bill {
	
	private BigDecimal summ;
	private String currency;
	private String country;
	
	public BigDecimal getSumm() {
		return summ;
	}
	public void setSumm(BigDecimal summ) {
		this.summ = summ;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}