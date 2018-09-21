package com.demo.spring.clients;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {

	public static void main(String[] args) {
		RestTemplate rt=new RestTemplate();
		
		//ResponseEntity<String> resp=rt.getForEntity("http://localhost:8081/emp/find?id=104", String.class);

		//System.out.println(resp.getBody());
		
		
		//stage2
		
		String userPass="shantanu:welcome1";
		String encodedCred=new String(Base64.encodeBase64(userPass.getBytes()));
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic "+encodedCred);
		
		HttpEntity req=new HttpEntity(headers);
		
		ResponseEntity<String> resp1=rt.exchange(
				"http://localhost:8081/emp/find?id=104", 
				HttpMethod.GET, 
				req, 
				String.class);

		System.out.println(resp1.getBody());
		}

}
