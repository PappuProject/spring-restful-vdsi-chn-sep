package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.service.HrService;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		HrService service=(HrService)ctx.getBean("hrService");
		System.out.println(service.registerEmployee(100, "James", "London", 89000));

	}

}
