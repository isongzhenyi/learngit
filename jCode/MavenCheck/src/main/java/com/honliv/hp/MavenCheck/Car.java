package com.honliv.hp.MavenCheck;

public class Car
{
	float	price;
	String	brand;

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	@Override
	public String toString()
	{
		return "Car [price=" + price + ", brand=" + brand + "]";
	}
}
