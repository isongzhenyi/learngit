package com.honliv.hp.it.interfaceCheck;

public class FirstClass implements FisterInterface
{

	@Override
	public int functionOne(int a, int b)
	{
		// TODO Auto-generated method stub
		return a + b + b + a;
	}

	@Override
	public int functionTwo(int a, int b, int c)
	{
		// TODO Auto-generated method stub
		return a + b + c + c;
	}

}
