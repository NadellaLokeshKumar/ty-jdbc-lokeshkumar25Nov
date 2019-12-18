package com.ty.asset.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="appartments")
public class Appartments {

	@Column
	@Id
	@GeneratedValue
	private int appartmentId;
	@Column
	private String appartmentArea;
	@Column
	private String appartmentName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "appartmentId", nullable = false)
	private List<Flats> flats; 
	
	public List<Flats> getFlats() {
		return flats;
	}
	public void setFlats(List<Flats> flats) {
		this.flats = flats;
	}
	public int getAppartmentId() {
		return appartmentId;
	}
	public void setAppartmentId(int appartmentId) {
		this.appartmentId = appartmentId;
	}
	public String getAppartmentName() {
		return appartmentName;
	}
	public void setAppartmentName(String appartmentName) {
		this.appartmentName = appartmentName;
	}
	public String getAppartmentArea() {
		return appartmentArea;
	}
	public void setAppartmentArea(String appartmentArea) {
		this.appartmentArea = appartmentArea;
	}
	
}
