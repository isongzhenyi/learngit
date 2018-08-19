package com.bjsxt.thread.pro;

/**
 * 生产者
 * 
 * @author Administrator
 *
 */
public class Player implements Runnable
{
	private Movie m;

	public Player(Movie m)
	{
		super();
		this.m = m;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			if (0 == i % 2)
			{
				m.play(i+"左青龙");
			} else
			{
				m.play(i+"右白虎");
			}
		}
	}

}
