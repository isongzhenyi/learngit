package com.honli.hp.it.proxy;

public class ProxyObjectStatic implements ProxyInterface
{
	private ProxyInterface proxyInterfaceImpl ;
	
	public ProxyObjectStatic  (ProxyInterface proxyInterfaceImpl)
	{
		this.proxyInterfaceImpl = proxyInterfaceImpl ;
	}

	@Override
	public void doSomeThing()
	{
		// TODO Auto-generated method stub
		System.out.println("做一些事情-前");
		proxyInterfaceImpl.doSomeThing();
		System.out.println("做一些事情-后");
	}

	@Override
	public void doSomeThing2()
	{
		// TODO Auto-generated method stub
		System.out.println("2做一些事情-前");
		proxyInterfaceImpl.doSomeThing2();
		System.out.println("2做一些事情-后");
	}

}