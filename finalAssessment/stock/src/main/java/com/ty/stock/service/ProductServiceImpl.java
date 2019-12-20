package com.ty.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.stock.dao.ProductsDAO;
import com.ty.stock.dto.Order_Info;
import com.ty.stock.dto.Products_Info;
@Service
public class ProductServiceImpl implements ProductsService{

	@Autowired
	private ProductsDAO dao;
	
	@Override
	public boolean addProduct(Products_Info bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean updateProduct(Products_Info bean) {
		return dao.updateProduct(bean);
	}

	@Override
	public Order_Info addToCart(Order_Info bean) {
		return dao.addToCart(bean);
	}

	@Override
	public List<Products_Info> allProducts() {
		return dao.allProducts();
	}

	@Override
	public Products_Info searchById(int id) {
		return dao.searchById(id);
	}

}
