package com.honliv.hp.it.aop.annotation.Autowired;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
	@Test
	public void test()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/honliv/hp/it/aop/annotation/Autowired/Beans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
		context.close();
	}
}
