package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	private EmpDao dao;
	


	@Transactional
	public String registerEmployee(int id,String name,String city,double salary) {
		String response=dao.save(new Emp(id, name, city, salary));
		return response;
	}
	
	public List<Emp> getEmpList(){
		return dao.getAll();
	}
	
	public Emp findOne(int id) {
		return dao.findById(id);
	}
}
