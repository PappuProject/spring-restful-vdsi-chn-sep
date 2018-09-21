package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	@Qualifier("jpaRepo")
	private EmpDao dao;


	public String registerEmployee(int id,String name,String city,double salary) {
		String response=dao.save(new Emp(id, name, city, salary));
		return response;
	}
}
