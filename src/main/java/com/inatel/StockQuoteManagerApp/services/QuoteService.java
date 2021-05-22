package com.inatel.StockQuoteManagerApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inatel.StockQuoteManagerApp.domain.Quote;
import com.inatel.StockQuoteManagerApp.repositories.QuoteRepository;
import com.inatel.StockQuoteManagerApp.services.exceptions.ResourceNotFoundException;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;
	
	public List<Quote> findAll(){
		return quoteRepository.findAll();
	}
	
	public Quote findById(String id) {
		Optional<Quote> obj = quoteRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Quote insert(Quote obj) {
		return quoteRepository.save(obj);
	}
}
