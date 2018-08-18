package com.bjsxt.thread.status;


/**
 * Sleepģ�� ������ʱ  �̲߳���ȫ����
 * @author Administrator
 *
 */
public class SleepDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��ʵ��ɫ
		Web12306 web= new Web12306();
		@SuppressWarnings("unused")
		Web12306 web2 = new Web12306();
		//����
		Thread t1 =new Thread(web,"·�˼�");
		Thread t2 =new Thread(web,"��ţ��");
		Thread t3 =new Thread(web,"����ʦ");
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
	}

}

class Web12306 implements Runnable {
	private int num =50;

	@Override
	public void run() {
		while(true){
			if(num<=0){
				break; //����ѭ��
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������"+num--);
		}
	}
	
	
}
