package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Bootstrap {

	public static void main(String[] args) {
		System.out.println("MPD Listening...");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		

	}

}
