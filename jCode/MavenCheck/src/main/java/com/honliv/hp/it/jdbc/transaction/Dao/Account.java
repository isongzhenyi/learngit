package com.honliv.hp.it.jdbc.transaction.Dao;

public class Account
{
	
	private Integer	id;
	private String	aname;
	private double	balance;
	 
	public double getBalance()
	{
		return balance;
	}
	 
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	 
	 
	 
	public Integer getId()
	{
		return id;
	}
	 
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "Account [id=" + id + ", name=" + aname + ", balance=" + balance + "]";
	}

	public String getAname()
	{
		return aname;
	}

	public void setAname(String aname)
	{
		this.aname = aname;
	}
}
