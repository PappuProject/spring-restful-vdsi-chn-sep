package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	@RequestMapping(path = "/greet/{name}", method = RequestMethod.GET)
	
	public String greetWithRest(@PathVariable("name") String name) {
		return name + " Welcome to Spring RESTful Service";
	}

	@GetMapping(path = "/emp/find", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> findEmp(@RequestParam("id") int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.ok("Not Found");
		}
	}

	@GetMapping(path = "/emp", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Emp>> findAll() {

		return ResponseEntity.ok(repo.findAll());

	}

	@PostMapping(path = "/emp/save", produces = {
			MediaType.TEXT_PLAIN_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e) {

		if (repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee Aready exists..");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Emp Saved...");
		}

	}

	@PutMapping(path = "/emp/update", produces = {
			MediaType.TEXT_PLAIN_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> updateEmp(@RequestBody Emp e) {

		Emp e1 = repo.save(e);
		return ResponseEntity.ok(e1);

	}

	@DeleteMapping(path = "/emp/delete", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> delete(@RequestParam("id") int id) {
		repo.deleteById(id);
		return ResponseEntity.ok("Emp Deleted");
	}

}
