package com.ty.asset.dao;

import com.ty.asset.dto.CandidateBean;

public interface CandidateDAO {

	public boolean addCandidate(CandidateBean bean);
	public CandidateBean login(String email, String password);
}
