package com.honliv.hp.it.interfaceCheck;

public class SencodClass implements SecondInterface
{

	@Override
	public int functionOne(int a, int b)
	{
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int functionTwo(int a, int b, int c)
	{
		// TODO Auto-generated method stub
		return a-b-c;
	}

	@Override
	public void close()
	{
		// TODO Auto-generated method stub
         System.out.println("i will close this ……");
	}

}
