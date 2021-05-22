package com.inatel.StockQuoteManagerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.StockQuoteManagerApp.domain.Quote;

public interface QuoteRepository extends JpaRepository<Quote, String>{

}
