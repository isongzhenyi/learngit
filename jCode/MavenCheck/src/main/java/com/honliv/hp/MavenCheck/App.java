package com.honliv.hp.MavenCheck;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App
{
	public static void main(String[] args)   
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Car car = (Car) context.getBean("car");
		System.out.println(car);
        Logger logger = Logger.getLogger(Car.class)   ;
        logger.info("this is my info");
        logger.info(car);
        
	}
}
