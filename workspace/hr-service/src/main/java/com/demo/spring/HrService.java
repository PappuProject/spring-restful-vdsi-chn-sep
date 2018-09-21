package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;

	public Emp processFind(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);

		ResponseEntity<Emp> resp1 = rt.exchange("http://localhost:8081/emp/find?id="+id,
				HttpMethod.GET, req,
				Emp.class);
		return resp1.getBody();
	}

	public List<Emp> processList() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);

		ResponseEntity<List<Emp>> resp1 = rt.exchange("http://localhost:8081/emp",
				HttpMethod.GET, req,
				new ParameterizedTypeReference<List<Emp>>() {
				});
		return resp1.getBody();
	}
}
