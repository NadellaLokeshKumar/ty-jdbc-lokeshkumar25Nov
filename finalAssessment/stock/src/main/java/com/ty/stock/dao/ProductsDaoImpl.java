package com.ty.stock.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ty.stock.dto.Order_Info;
import com.ty.stock.dto.Products_Info;

@Repository
public class ProductsDaoImpl implements ProductsDAO{
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean addProduct(Products_Info bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Products_Info bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		if(bean!=null) {
		transaction.begin();
		Products_Info beanA = manager.find(Products_Info.class, bean.getId());
		beanA.setName(bean.getName());
		beanA.setPrice(bean.getPrice());
		beanA.setCompany(bean.getCompany());
		beanA.setCategory(bean.getCategory());
		beanA.setQuantity(bean.getQuantity());
		transaction.commit();
		return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<Products_Info> allProducts() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Products_Info";
		TypedQuery<Products_Info> query = manager.createQuery(jpql, Products_Info.class);
		List<Products_Info> beans = query.getResultList();
		return beans;
	}

	@Override
	public Products_Info searchById(int id) {
		EntityManager manager = factory.createEntityManager();
		Products_Info bean = manager.find(Products_Info.class, id);
		return bean;
	}

	@Override
	public Order_Info addToCart(Order_Info bean) {
		double cost = 0.0;
		double totalCostGst = 0.0;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<Products_Info> products = bean.getProducts();
		Iterator<Products_Info> it = products.iterator();
		while(it.hasNext()) {
			Products_Info product = it.next();
			cost = cost + product.getPrice();
			totalCostGst = totalCostGst + product.getPrice() + (product.getPrice()*0.12);  //let gst is 12% of product price.
			Products_Info info = manager.find(Products_Info.class, product.getId());
			info.setQuantity(info.getQuantity()-1);
			}
			bean.setTotalPrice(cost);
			bean.setTotalPriceGst(totalCostGst);
			try {
				transaction.begin();
				manager.persist(bean);
				transaction.commit();
				return bean;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}

}
