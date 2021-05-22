package com.inatel.StockQuoteManagerApp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inatel.StockQuoteManagerApp.domain.Stock;
import com.inatel.StockQuoteManagerApp.services.StockService;

@RestController
@RequestMapping(value = "/stocks")
public class StockResource {
	
	@Autowired
	private StockService service;
	
	@GetMapping
	public ResponseEntity<List<Stock>> findAll(){
		List<Stock> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Stock> findById(@PathVariable String id){
		Stock obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Stock> insert(@RequestBody Stock obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
