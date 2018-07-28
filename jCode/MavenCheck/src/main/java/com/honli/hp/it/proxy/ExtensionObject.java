package com.honli.hp.it.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 将要扩展的功能写在一个InvocationHandler的实现类
 * Proxy.newProxyInstance中的一个参数
 * */
public class ExtensionObject implements InvocationHandler
{
	// 目标对象
	private Object target;

	public ExtensionObject(Object target)
	{
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// TODO Auto-generated method stub
/* 		增强功能写在这里*/
		System.out.println("此处写增加代码");
		return method.invoke(target, args);
	}
}
