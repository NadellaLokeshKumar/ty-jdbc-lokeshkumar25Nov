package com.ty.stock.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class Order_Info {
	@Column
	@Id
	@GeneratedValue
	private int oId;
	@Column
	private double totalPrice;
	@Column
	private double totalPriceGst;
	@ManyToMany
	@JoinTable(name="OrderHistoryInfo", joinColumns=@JoinColumn(name="oId"),inverseJoinColumns=@JoinColumn(name="id"))
	private List<Products_Info> products;
	
	public List<Products_Info> getProducts() {
		return products;
	}
	public void setProducts(List<Products_Info> products) {
		this.products = products;
	}
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalPriceGst() {
		return totalPriceGst;
	}
	public void setTotalPriceGst(double totalPriceGst) {
		this.totalPriceGst = totalPriceGst;
	}
	
}
