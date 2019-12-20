package com.ty.stock.dto;

import java.util.List;

public class StockResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Products_Info> product;
	
	public List<Products_Info> getProduct() {
		return product;
	}
	public void setProduct(List<Products_Info> product) {
		this.product = product;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
