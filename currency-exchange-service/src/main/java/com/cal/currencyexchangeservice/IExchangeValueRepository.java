package com.cal.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
