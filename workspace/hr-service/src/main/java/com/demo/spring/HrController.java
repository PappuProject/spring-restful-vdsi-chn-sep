package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class HrController {
	@Autowired
	HrService service;

	@GetMapping(path = "/hr/emp/{id}", produces = "application/json")
	public ResponseEntity<Emp> getEmp(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.processFind(id));
	}
	
	@GetMapping(path = "/hr/emp/list", produces = "application/json")
	public ResponseEntity<List<Emp>> getEmpList() {
		return ResponseEntity.ok(service.processList());
	}
}
