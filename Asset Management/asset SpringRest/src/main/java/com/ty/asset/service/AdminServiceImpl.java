package com.ty.asset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.asset.dao.AdminDAO;
import com.ty.asset.dto.Appartments;
import com.ty.asset.dto.CandidateBean;
import com.ty.asset.dto.Flats;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO dao;

	@Override
	public boolean addAsset(Appartments bean) {

		return dao.addAsset(bean);
	}

	@Override
	public boolean modifyAsset(Appartments bean) {

		return dao.modifyAsset(bean);
	}

	@Override
	public boolean addCandidate(CandidateBean bean) {

		return dao.addCandidate(bean);
	}

	@Override
	public boolean removeCandidate(int id) {

		return dao.removeCandidate(id);
	}

	@Override
	public List<Appartments> getAll() {
		
		return dao.getAll();
	}

	@Override
	public List<CandidateBean> getAllCan() {
	
		return dao.getAllCan();
	}

	@Override
	public boolean removeAsset(int appartmentId) {
		
		return dao.removeAsset(appartmentId);
	}

	@Override
	public boolean bookFlat(Flats flat) {
	
		return dao.bookFlat(flat);
	}

	@Override
	public List<Flats> requests() {
	
		return dao.requests();
	}

	@Override
	public boolean approve(Flats flat) {
	
		return dao.approve(flat);
	}

	@Override
	public boolean reject(Flats flat) {
	
		return dao.reject(flat);
	}

	@Override
	public Flats seeReq(Flats flat) {
		
		return dao.seeReq(flat);
	}

//	@Override
//	public List<Flats> getAllFlats() {
//	
//		return dao.getAllFlats();
//	}


}
