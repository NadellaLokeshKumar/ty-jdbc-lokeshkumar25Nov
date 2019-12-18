package com.ty.asset.dao;

import java.util.List;

import com.ty.asset.dto.Appartments;
import com.ty.asset.dto.CandidateBean;
import com.ty.asset.dto.Flats;

public interface AdminDAO {

	public boolean addAsset(Appartments bean);
	public boolean modifyAsset(Appartments bean);
	public boolean addCandidate(CandidateBean bean);
	public boolean removeCandidate(int id);
	public boolean removeAsset(int appartmentId);
	public List<Appartments> getAll();
//	public List<Flats> getAllFlats();
	public List<CandidateBean> getAllCan();
	public boolean bookFlat(Flats flat);
	public List<Flats> requests();
	public boolean approve(Flats flat);
	public boolean reject(Flats flat);
	public Flats seeReq(Flats flat);
}
