package com.honliv.hp.MavenCheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App
{
	public static void main(String[] args)   
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Car car = (Car) context.getBean("car");
		System.out.println(car);
          
	}
}
