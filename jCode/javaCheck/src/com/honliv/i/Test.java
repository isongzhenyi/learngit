package com.honliv.i;
 
public class Test
{
	@org.junit.Test
	public void name()
	{
		TestClass testClass = new TestClass();
		testClass.setMyAge((short) 30);
		testClass.setMyName("songzhneyi");
		System.out.println(testClass);
	}

	@org.junit.Test
	public void name2()
	{
		TestClass testClass = new TestClass();
		testClass.setMyAge((short) 30);
		testClass.setMyName("hanliwen");
		System.out.println(testClass);
	}
	
	@org.junit.Before
	public void Before()
	{
		System.out.println("Before");
	}
	
	@org.junit.After
	public void After()
	{		 
		System.out.println("After");
	}
}
