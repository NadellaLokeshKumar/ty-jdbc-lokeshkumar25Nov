package com.ty.asset.service;

import com.ty.asset.dto.CandidateBean;

public interface CandidateService {

	public boolean addCandidate(CandidateBean bean);
	public CandidateBean login(String email, String password);
}
