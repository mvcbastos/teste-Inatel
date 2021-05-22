package com.inatel.StockQuoteManagerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.StockQuoteManagerApp.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, String>{

}
