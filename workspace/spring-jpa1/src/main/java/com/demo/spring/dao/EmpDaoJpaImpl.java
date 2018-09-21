package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;
	@Override
	public String save(Emp e) {
		em.persist(e);
		return "saved";
	}

	@Override
	public String update(Emp e) {
		
			em.merge(e);
		return "updated";
	}

	@Override
	public String delete(int id) {
		
		return null;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e=em.find(Emp.class, id);
		return e;
	}

}
