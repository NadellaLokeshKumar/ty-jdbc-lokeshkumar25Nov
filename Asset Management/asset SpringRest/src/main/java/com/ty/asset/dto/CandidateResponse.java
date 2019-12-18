package com.ty.asset.dto;

import java.util.List;

public class CandidateResponse {
	private int statusCode;
	private String message;
	private String description;
	private CandidateBean candidate;
	private List<Appartments> appartments;
	private List<Flats> flats;
	private Flats flat;
	
	public Flats getFlat() {
		return flat;
	}
	public void setFlat(Flats flat) {
		this.flat = flat;
	}
	public List<Flats> getFlats() {
		return flats;
	}
	public void setFlats(List<Flats> flats) {
		this.flats = flats;
	}
	private List<CandidateBean> candidates;
	
	
	public List<CandidateBean> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<CandidateBean> candidates) {
		this.candidates = candidates;
	}
	public List<Appartments> getAppartments() {
		return appartments;
	}
	public void setAppartments(List<Appartments> appartments) {
		this.appartments = appartments;
	}

	public CandidateBean getCandidate() {
		return candidate;
	}
	public void setCandidate(CandidateBean candidate) {
		this.candidate = candidate;
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
