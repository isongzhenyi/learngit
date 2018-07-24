package com.honliv.i;

public class Test
{
	@org.junit.Test
	public void name()
	{
//		System.out.println("this is my first test");
		TestClass testClass = new TestClass();
		testClass.setMyAge((short) 30);
		testClass.setMyName("songzhneyi");
		System.out.println(testClass);
	}

}
