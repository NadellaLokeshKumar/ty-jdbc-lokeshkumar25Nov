package com.ty.asset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.ty.asset.dto.Appartments;
import com.ty.asset.dto.CandidateBean;
import com.ty.asset.dto.Flats;

@Repository
public class AdminDaoImpl implements AdminDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addAsset(Appartments bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean modifyAsset(Appartments bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Appartments beanA = manager.find(Appartments.class, bean.getAppartmentId());
		beanA.setAppartmentArea(bean.getAppartmentArea());
		beanA.setAppartmentName(bean.getAppartmentName());
		beanA.setFlats(bean.getFlats());
		transaction.commit();
		return true;
	}

	@Override
	public boolean addCandidate(CandidateBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean removeCandidate(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		CandidateBean bean = manager.find(CandidateBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Appartments> getAll() {
		String jpql = "from Appartments";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Appartments> query = manager.createQuery(jpql, Appartments.class);
		List<Appartments> appartments = query.getResultList();
		return appartments;
	}

	@Override
	public List<CandidateBean> getAllCan() {
		String jpql = "from CandidateBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<CandidateBean> query = manager.createQuery(jpql, CandidateBean.class);
		List<CandidateBean> candidates = query.getResultList();
		return candidates;
	}

	@Override
	public boolean removeAsset(int appartmentId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Appartments bean = manager.find(Appartments.class, appartmentId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean bookFlat(Flats flat) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Flats flatA = manager.find(Flats.class, flat.getFlatId());
			flatA.setStatus("Requested");
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Flats> requests() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Flats where status='Requested'";
		TypedQuery<Flats> query = manager.createQuery(jpql, Flats.class);
		List<Flats> flats = query.getResultList();
		return flats;
	}

	@Override
	public boolean approve(Flats flat) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Flats flatA = manager.find(Flats.class, flat.getFlatId());
			flatA.setStatus("Approved");
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean reject(Flats flat) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Flats flatA = manager.find(Flats.class, flat.getFlatId());
			flatA.setStatus("Rejected");
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Flats seeReq(Flats flat) {
		EntityManager manager = factory.createEntityManager();
		Flats flatA = manager.find(Flats.class, flat.getFlatId());
		return flatA;
	}

//	@Override
//	public List<Flats> getAllFlats() {
//		String jpql = "from Flats";
//		EntityManager manager = factory.createEntityManager();
//		TypedQuery<Flats> query = manager.createQuery(jpql, Flats.class);
//		List<Flats> flats = query.getResultList();
//		return flats;
//	
//	}


}
