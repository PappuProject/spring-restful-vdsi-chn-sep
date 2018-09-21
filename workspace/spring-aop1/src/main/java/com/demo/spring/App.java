package com.demo.spring;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		Performer p = (Performer) ctx.getBean("singer");
		
		//Singer p = (Singer) ctx.getBean("singer");
		p.perform();
		
		System.out.println(p.getClass().getName());
		/*
		Method[] methods=p.getClass().getDeclaredMethods();
		
		for(Method m:methods) {
			System.out.println(m.getName());
		}*/
		
		
		Arrays.asList(p.getClass().getMethods()).stream().forEach(m->System.out.println(m.getName()));

	}

}
