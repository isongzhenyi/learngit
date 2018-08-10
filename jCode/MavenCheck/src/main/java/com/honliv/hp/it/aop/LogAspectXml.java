package com.honliv.hp.it.aop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.springframework.aop.MethodBeforeAdvice;

public class LogAspectXml implements MethodBeforeAdvice
{
	public void before(Method method, Object[] args, Object target) throws Throwable
	{
		System.out.println();	
		System.out.println(LocalDateTime.now()+ method.getName()+ "前置增强"+args[0].toString());
	}
}
