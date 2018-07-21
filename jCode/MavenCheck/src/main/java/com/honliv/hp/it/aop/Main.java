package com.honliv.hp.it.aop;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

	public static void main(String[] args) throws BeansException
	{
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		((ConfigurableApplicationContext)ctx).close();
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(1000, 10);
		System.out.println("result:" + result);
	}

}
