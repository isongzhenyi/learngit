package com.honliv.hp.it.interfaceCheck;

public class SencodClass implements SecondInterface
{

	public int functionOne(int a, int b)
	{
		// TODO Auto-generated method stub
		return a+b;
	}

	public int functionTwo(int a, int b, int c)
	{
		// TODO Auto-generated method stub
		return a-b-c;
	}

	public void close()
	{
		// TODO Auto-generated method stub
         System.out.println("i will close this ……");
	}

}
