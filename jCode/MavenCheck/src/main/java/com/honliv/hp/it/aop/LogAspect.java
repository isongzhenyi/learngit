package com.honliv.hp.it.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect
{
    @Before("execution(int com.honliv.hp.it.aop.ArithmeticCalculatorImpl.add(int, int ))")
	public void beforeFunction()
	{
		System.out.println("Before Function!");
	}
}
