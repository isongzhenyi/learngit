package com.honliv.hp.it.interfaceCheck;

public class Main
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		FisterInterface one = new FirstClass();
		System.out.println(one.functionOne(4, 6));
  		((SecondInterface)one).close();
		((SencodClass) one).close();
	}
}
