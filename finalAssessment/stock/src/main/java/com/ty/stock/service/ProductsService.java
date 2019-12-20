package com.ty.stock.service;

import java.util.List;

import com.ty.stock.dto.Order_Info;
import com.ty.stock.dto.Products_Info;

public interface ProductsService {

	public boolean addProduct(Products_Info bean);
	public boolean updateProduct(Products_Info bean);
	public Products_Info searchById(int id);
	public List<Products_Info> allProducts();
	public Order_Info addToCart(Order_Info bean);
}
