package com.honliv.hp.it.template;

public class CustomerShopping extends ShoppingService
{

	@Override
	public void choose()
	{
		// TODO Auto-generated method stub
        System.out.println("我选择了华为手机");
	}
	
	@Override
	public String pay()
	{
		// TODO Auto-generated method stub
		System.out.println("我选择了华为手机");
		return "我选择了华为手机" ;
	}

}
