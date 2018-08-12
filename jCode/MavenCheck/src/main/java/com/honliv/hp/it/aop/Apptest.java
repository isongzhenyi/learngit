package com.honliv.hp.it.aop;

import java.lang.reflect.Method;

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

	// 非注解、非xml形式实现
	@Test
	public void testProxyFactory()
	{
		ArithmeticCalculatorImplXml target = new ArithmeticCalculatorImplXml();
		LogAspectXml aspectXml = new LogAspectXml();
		LogAspectXml aspectXml2 = new LogAspectXml();
		ProxyFactory proxyFactory = new ProxyFactory();

		proxyFactory.setTarget(target);
		// 一个目标对应两个切面
		proxyFactory.addAdvice(aspectXml);
		proxyFactory.addAdvice(aspectXml2);
		
		ArithmeticCalculatorImplXml proxy = (ArithmeticCalculatorImplXml) proxyFactory.getProxy();
		System.out.println(proxy.add(10, 2));
		System.out.println(proxy.sub(6, 2));
	}
	
	@Test
	public void tool()
	{
		Class<ForumService> clazz = ForumService.class;
		Method[] methods = clazz.getDeclaredMethods();
		
		System.out.println(methods.length);
		
		for (Method method : methods)
		{
			NeedTest nTest = method.getAnnotation(NeedTest.class);
			
			if (nTest!=null)
			{
				if (nTest.value())
				{
					System.out.println(method.getName()+"() 需要测试");
				}
				else
				{
					System.out.println(method.getName()+"() 不需要测试");
				}
			}
		}
	}
}
