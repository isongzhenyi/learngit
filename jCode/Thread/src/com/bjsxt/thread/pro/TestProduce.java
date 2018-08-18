package com.bjsxt.thread.pro;

public class TestProduce
{
	public static void main(String[] args)
	{
		SyncStack sStack = new SyncStack();
		Shengchan sc = new Shengchan(sStack);
		Xiaofei xf = new Xiaofei(sStack);
		sc.start();
		xf.start();
	}
}

class Mantou
{
	int id;

	Mantou(int id)
	{
		this.id = id;
	}
}

class SyncStack
{
	int index = 0;
	Mantou[] ms = new Mantou[10];

	public synchronized void push(Mantou m)
	{
		while (index == ms.length)
		{
			try
			{
				this.wait();
				// wait���̻߳Ὣ���е����ͷš�sleep�Ǽ�ʹ˯��Ҳ���л�������
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notify(); // �����ڵ�ǰ����ȴ����еȴ��ĵ�һ���̡߳�notifyAll���������ڵ�ǰ����ȴ����еȴ��������̡߳�
		// ��������ѵĻ����Ժ��������̶߳������ȴ��̣߳�û���˻��ѡ�
		ms[index] = m;
		index++;
	}

	public synchronized Mantou pop()
	{
		while (index == 0)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return ms[index];
	}
}

class Shengchan extends Thread
{
	SyncStack ss = null;

	public Shengchan(SyncStack ss)
	{
		this.ss = ss;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			System.out.println("����ͷ��" + i);
			Mantou m = new Mantou(i);
			ss.push(m);
		}
	}
}

class Xiaofei extends Thread
{
	SyncStack ss = null;

	public Xiaofei(SyncStack ss)
	{
		this.ss = ss;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			@SuppressWarnings("unused")
			Mantou m = ss.pop();
			System.out.println("����ͷ��" + i);

		}
	}
}
