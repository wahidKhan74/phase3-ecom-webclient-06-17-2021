package com.mcit.rest.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mcit.rest.consumer.entity.Product;

@RestController
@RequestMapping("/consumer")
public class ProductConsumerController {
	
	String uri ="http://localhost:4000/api/products/";
	
	@GetMapping("/products/{id}")
	public Product fetchOneProduct(@PathVariable("id") long id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForObject(uri+id,Product.class );
	}
	
	@PutMapping("/products/{id}")
	public String updateOneProduct(@PathVariable("id") long id, @RequestBody Product product) {
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri+id, product);
		return "product is updated sucessfully";
	}

}
