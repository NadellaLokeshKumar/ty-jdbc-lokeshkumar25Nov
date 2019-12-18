package com.ty.asset.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ty.asset.dto.CandidateBean;

@Repository
public class CandidateDaoImpl implements CandidateDAO{

	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public boolean addCandidate(CandidateBean bean) {
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
	public CandidateBean login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from CandidateBean where email=:email and password=:password";
		TypedQuery<CandidateBean> query = manager.createQuery(jpql, CandidateBean.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			CandidateBean bean = query.getSingleResult();
			return bean;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
