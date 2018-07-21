package com.honliv.hp.it.aop;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator
{

	@Override
	public int add(int a, int b)
	{
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b)
	{
		// TODO Auto-generated method stub
		return a - b ;
	}

	@Override
	public int div(int a, int b)
	{
		// TODO Auto-generated method stub
		return a/b;
	}

}
