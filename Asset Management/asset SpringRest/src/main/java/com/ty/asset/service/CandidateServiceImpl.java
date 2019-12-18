package com.ty.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.asset.dao.CandidateDAO;
import com.ty.asset.dto.CandidateBean;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateDAO dao;
	
	@Override
	public boolean addCandidate(CandidateBean bean) {
		
		return dao.addCandidate(bean);
	}

	@Override
	public CandidateBean login(String email, String password) {
		
		return dao.login(email, password);
	}

}
