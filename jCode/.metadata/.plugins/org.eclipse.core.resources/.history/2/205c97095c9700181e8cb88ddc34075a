package com.honliv.hp.it.aop;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Apptest
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("AopXml.xml");
		System.out.println("开始测试");
		ArithmeticCalculator server = (ArithmeticCalculator) context.getBean("userServiceProxy");
		System.out.println(server.add(10, 1));
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testWithClassPathXmlApplicationContext()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AopXml.xml");
		System.out.println("开始测试");
		ArithmeticCalculator server = (ArithmeticCalculator) context.getBean("userServiceProxy");
		System.out.println(server.add(10, 1));
		context.close();
	}

	
	@Test
	public void testProxyFactory()
	{
		ArithmeticCalculatorImplXml target = new ArithmeticCalculatorImplXml();
		LogAspectXml aspectXml = new LogAspectXml();
		ProxyFactory proxyFactory = new ProxyFactory();

		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(aspectXml);

		ArithmeticCalculatorImplXml proxy = (ArithmeticCalculatorImplXml) proxyFactory.getProxy();
		System.out.println(proxy.add(10, 2));
	}

}
