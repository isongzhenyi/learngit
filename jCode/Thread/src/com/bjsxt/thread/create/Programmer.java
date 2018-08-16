package com.bjsxt.thread.create;
/**
 �Ƽ�  Runnable �����߳�
 1)�����ⵥ�̳еľ�����
 2)�����ڹ�����Դ
  
  
  ʹ�� Runnable �����߳�
  1���� ʵ�� Runnable�ӿ� +��д run()   -->��ʵ��ɫ��
  2���������߳�  ʹ�þ�̬����
    1)��������ʵ��ɫ
    2)�����������ɫ +��ʵ��ɫ����
    3)������ .start() �����߳�
  
  
 * @author Administrator
 *
 */
public class Programmer implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("һ����helloworld....");
		}
	}
}
