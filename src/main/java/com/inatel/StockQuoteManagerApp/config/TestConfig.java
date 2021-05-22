package com.inatel.StockQuoteManagerApp.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.inatel.StockQuoteManagerApp.domain.Quote;
import com.inatel.StockQuoteManagerApp.domain.Stock;
import com.inatel.StockQuoteManagerApp.repositories.QuoteRepository;
import com.inatel.StockQuoteManagerApp.repositories.StockRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private QuoteRepository quoteRepository;

	@Override
	public void run(String... args) throws Exception {
		Stock stock1 = new Stock("vale5");
		Stock stock2 = new Stock("csna3");
		
		Quote q1 = new Quote(null,Instant.now(),32.0,stock1);
		Quote q2 = new Quote(null,Instant.now(),53.0,stock2);
		Quote q3 = new Quote(null,Instant.now(),47.0,stock1);
		
		stockRepository.saveAll(Arrays.asList(stock1,stock2));
		quoteRepository.saveAll(Arrays.asList(q1,q2,q3));
	}
	
	
}
