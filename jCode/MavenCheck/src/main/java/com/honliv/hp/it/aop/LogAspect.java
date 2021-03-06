package com.honliv.hp.it.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect
{
    @Before("execution( * com.honliv.hp.it.aop.ArithmeticCalculatorImpl.*(.. ))")
	public void beforeFunction(JoinPoint joinPoint)
	{
    	String funtionName = joinPoint.getSignature().getName();
    	List<Object> parms = Arrays.asList(  joinPoint.getArgs());
		System.out.println("Before Function " + funtionName+" parms :"+parms);
	}
}
