package com.honli.hp.it.proxy;


public class AppTest
{
	@org.junit.Test
    public void testStaticProxy()
	{
		ProxyInterface targe = new ProxyInterfaceImpl();
		
		ProxyInterface proxyOjbect = new ProxyObject(targe);
		
		proxyOjbect.doSomeThing();
	}
}
