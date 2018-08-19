package com.bjsxt.thread.pro;

/**
 * 一个场景,共同的资源 生产者消费者模式 信号灯法 
 * wait() :等待，释放锁 sleep 不释放锁
notify()/notifyAll():唤醒 与 * synchronized *
 * 
 * @author Administrator
 *
 *java wait() notify() 解释
 *http://blog.163.com/kellyzly@126/blog/static/12972526420111684155384/
 */
public class Movie
{
	private String	pic;
	// 信号灯
	// flag -->T 生产生产，消费者等待 ，生产完成后通知消费
	// flag -->F 消费者消费 生产者等待, 消费完成后通知生产
    //wait() 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，当前线程等待。
    //notifyAll()  唤醒在此对象监视器上等待的所有线程
	private boolean	flag	= true;

	/**
	 * 播放
	 * 
	 * @param pic
	 */
	public synchronized void play(String pic)
	{
		if (!flag)
		{ // 生产者等待
			try
			{
				System.out.println("play 生产者等待……");
				this.wait();				
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// 开始生产
		try
		{
			System.out.println("play 生产者开始生产……");
			Thread.sleep(50);			
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("生产了:" + pic);
		// 生产完毕
		this.pic = pic;
		// 通知消费
		this.notify();
		// 生产者停下
		System.out.println("生产者停下:" + pic+"通知消费");
		this.flag = false;
	}

	public synchronized void watch()
	{
		if (flag)
		{ // 消费者等待
			try
			{
				System.out.println("消费者等待……");
				this.wait();				
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// 消费开始
		try
		{
			System.out.println("watch 消费者消费开始……");
			Thread.sleep(20);
			
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("消费了" + pic+"通知生产");
		// 消费完毕
		// 通知生产
		this.notifyAll();
		// 消费停止
		this.flag = true;
		System.out.println("消费了" + pic+"通知生产flag = true");
	}
}
