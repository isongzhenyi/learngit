package com.honliv.hp.it.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AccountServerCglibProxy implements MethodInterceptor
{

	private AccountServer target;

	public AccountServerCglibProxy(AccountServer target)
	{
		this.target = target;
	}

	AccountServer createProxy()
	{
		Enhancer enhancer = new Enhancer();
		// 设置需要创建子类的类
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		// 通过字节码技术动态创建子类实例
		return (AccountServer)enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
	{
		// TODO Auto-generated method stub
		System.out.println("前置代理");
		// 通过代理类调用父类中的方法
		Object result = method.invoke(target, args);
		System.out.println("后置代理");
		return result;
	}

}
