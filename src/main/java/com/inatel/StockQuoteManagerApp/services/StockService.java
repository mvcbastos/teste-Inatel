package com.inatel.StockQuoteManagerApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inatel.StockQuoteManagerApp.domain.Stock;
import com.inatel.StockQuoteManagerApp.repositories.StockRepository;
import com.inatel.StockQuoteManagerApp.services.exceptions.ResourceNotFoundException;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> findAll(){
		return stockRepository.findAll();
	}
	
	public Stock findById(String id) {
		Optional<Stock> obj = stockRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Stock insert(Stock obj) {
		return stockRepository.save(obj);
	}
}
