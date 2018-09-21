package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.HrService;

public class DaoMain {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DaoConfig.class);
		
		HrService service=ctx.getBean(HrService.class);
		
		//Emp e = service.findOne(111);
		
		//System.out.println(e.getEmpId()+" "+e.getCity()+" "+e.getName());
		
		System.out.println(service.registerEmployee(115, "Rekha", "Chennai", 89000));
		
		System.out.println(service.getClass().getName());

	}

}
