package com.honliv.hp.it.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class AppTest
{
	@Test
	/*
	 * 测试静态代理 这种代理模式也最为简单，就是通过proxy持有realObject的引用，并进行一层封装。
	 * 优点：可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。
	 * 缺点：因为代理对象，需要实现与目标对象一样的接口，会导致代理类十分繁多，不易维护，同时一旦接口增加方法，则目标对象和代理类都需要维护。
	 */
	public void testStaticProxy()
	{

		ProxyInterface targe = new ProxyInterfaceImpl();

		ProxyInterface proxyOjbect = new ProxyObjectStatic(targe);

		proxyOjbect.doSomeThing();
//		proxyOjbect.doSomeThing2();
	}

	@Test
	/*
	 * 仔细体会这个过程，其实有点类似我们在静态代理中提到的方案一，生成了一个包含我们扩展功能，
	 * 持有RealObject引用，实现Action接口的代理实例Proxy。只不过这个Proxy不是我们自己写的，而是java帮我们生成的，
	 * 有没有一点动态的味道。 让我们再回顾一下代理三要素：真实对象：RealObject，代理接口：Action，代理实例：Proxy
	 * 上面的代码实含义也就是，输入 RealObject、Action，返回一个Proxy。妥妥的代理模式。 综上，动态生成+代理模式，也就是动态代理。
	 * 有一篇文章，推薦看看 https://blog.csdn.net/wangqyoho/article/details/77584832
	 */
	public void testDynamicProxy()
	{
		ProxyInterface tar = new ProxyInterfaceImpl();

		ProxyInterface proxyOjbect = (ProxyInterface) Proxy.newProxyInstance(tar.getClass().getClassLoader(),
				tar.getClass().getInterfaces(), new ExtensionObject(tar));
		// 此时执行的内容是增强过的内容
		proxyOjbect.doSomeThing();
	}

	@Test
	public void testCglibProxy()
	{
		AccountServer target = new AccountServer();
		AccountServer accountServer = new AccountServerCglibProxy(target).createProxy();

		accountServer.getBalance();
		//accountServer.transfer();
	}
}
