package com.honliv.hp.it.template;

public abstract class ShoppingService
{
// 模板方法
	public void shopping()
	{
		// 步骤方法
		login();
		choose();
		pay();
	}

	// 最终方法
	public final String login()
	{
		// TODO Auto-generated method stub
		System.out.println("用户成功登录");
		return "用户成功登陆";
	}

	// 抽象方法
	public abstract void choose();

	// 钩子方法
	public String pay()
	{
		// TODO Auto-generated method stub
		System.out.println("用户使用支付宝支付");
		return "用户使用支付宝支付";
	}

}
