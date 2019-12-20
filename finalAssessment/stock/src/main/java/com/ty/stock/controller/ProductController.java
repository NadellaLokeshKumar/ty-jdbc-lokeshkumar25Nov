package com.ty.stock.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.stock.dto.Order_Info;
import com.ty.stock.dto.Products_Info;
import com.ty.stock.dto.StockResponse;
import com.ty.stock.service.ProductsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ProductController {

	@Autowired
	private ProductsService service;

	@PostMapping(path="/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse productAdd(@RequestBody Products_Info bean) {
		StockResponse response = new StockResponse();
		if(service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("succesfully added product to DB");
			response.setProduct(Arrays.asList(bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Not added product to DB");
		}
		return response;
	}

	@PutMapping(path="/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse productUpdate(@RequestBody Products_Info bean) {
		StockResponse response = new StockResponse();
		if(service.updateProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("succesfully updated product in DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Not updated product to DB");
		}
		return response;
	}
	
	@GetMapping(path="/productById", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse searchByName(@RequestParam("id") int id) {
		StockResponse response = new StockResponse();
		Products_Info bean = service.searchById(id);
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("succesfully added product to DB");
			response.setProduct(Arrays.asList(bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Not added product to DB");
		}
		return response;
	}

	@PostMapping(path="/orderedProducts", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse orderedProducts(@RequestBody Order_Info bean) {
		StockResponse response = new StockResponse();
		Order_Info info = service.addToCart(bean);
		if(info!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("succesfully ordered");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("order not done");
		}
		return response;
	}
	@GetMapping(path="/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse allProducts() {
		StockResponse response = new StockResponse();
		if(!service.allProducts().isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("succesfully get all the products");
			response.setProduct(service.allProducts());
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("error occured, not found all products");
		}
		return response;
	}
}
