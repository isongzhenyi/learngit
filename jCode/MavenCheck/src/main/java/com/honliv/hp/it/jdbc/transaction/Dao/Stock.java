package com.honliv.hp.it.jdbc.transaction.Dao;

public class Stock
{
	private String	sname;
	private Integer	account;
	private Integer	id;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getSname()
	{
		return sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public Integer getAccount()
	{
		return account;
	}

	public void setAccount(Integer account)
	{
		this.account = account;
	}

	@Override
	public String toString()
	{
		return "Stock [id=" + id + ", sname=" + sname + ", account=" + account + "]";
	}
}
