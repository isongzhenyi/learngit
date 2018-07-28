package com.honli.hp.it.proxy;

public class ProxyObject implements ProxyInterface
{
	private ProxyInterface proxyInterfaceImpl ;
	
	public ProxyObject  (ProxyInterface proxyInterfaceImpl)
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

}
