package com.honliv.i;

public class TestClass
{
	String	myName;
	short	myAge;

	public String getMyName()
	{
		return myName;
	}

	public void setMyName(String myName)
	{
		this.myName = myName;
	}

	public short getMyAge()
	{
		return myAge;
	}

	public void setMyAge(short myAge)
	{
		this.myAge = myAge;
	}

	@Override
	public String toString()
	{
		return "TestClass [myName=" + myName + ", myAge=" + myAge + "]";
	}
}
