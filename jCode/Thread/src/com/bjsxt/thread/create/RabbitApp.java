package com.bjsxt.thread.create;

public class RabbitApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����������
		Rabbit rab = new Rabbit();
		Tortoise tor =new Tortoise();
		
		//����start ����
		//rab.start(); //��Ҫ����run����
		rab.run();
		//tor.start();
		tor.run();
		
		for(int i=0;i<1000;i++){
			System.out.println("main==>"+i);
		}
	}

}
