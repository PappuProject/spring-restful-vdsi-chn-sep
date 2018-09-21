package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Pointcut("execution(* com.demo.spring.*.perform(..))")
	private void pcut() {}

	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Auidience is taking seats....");
	}

	@Before("pcut()")
	public void switchOffMobiles() {
		System.out.println("Audience switching off mobiles...");
	}

	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Excellent! Clap! Clap!Clap!...");
	}
}
