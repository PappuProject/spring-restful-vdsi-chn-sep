package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Service
public class HrService {

	@Autowired
	private EmpRepository dao;
	


	@Transactional
	public String registerEmployee(int id,String name,String city,double salary) {
		Emp response=dao.save(new Emp(id, name, city, salary));
		return "saved";
	}
	
	public List<Emp> getEmpList(){
		return dao.findAll();
	}
	
	public Emp findOne(int id) {
		Optional<Emp> o= dao.findById(id);
		if(o.isPresent()) {
			return o.get();
		}else {
			throw new RuntimeException("Emp not found by this id!!");
		}
	}
}
