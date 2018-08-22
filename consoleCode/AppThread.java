public class AppThread {
	public static void main(String[] args) {
		//��ͬ����Դ
		Movie m = new Movie();

		//���߳�
		Player p = new Player(m);
		Watcher w = new Watcher(m);

		new Thread(p).start();
		new Thread(w).start();
	}
}

/**
 һ������,��ͬ����Դ
  ������������ģʽ �źŵƷ�
 wait() :�ȴ����ͷ���
 sleep ���ͷ���
 notify()/notifyAll():����
  �� synchronized
 * @author Administrator
 *
 */
class Movie {
	private String pic ;
	//�źŵ�
	//flag -->T ���������������ߵȴ� ��������ɺ�֪ͨ����
	//flag -->F ���������� �����ߵȴ�, ������ɺ�֪ͨ����
	private boolean flag =true;
	//private int order = 1;
	/**
	 * ����
	 * @param pic
	 */
	public synchronized void play(String pic) {
		if(!flag) { //�����ߵȴ�
			try {
				System.out.println("������        ��ʼ�ȴ�����"+pic);
				// ��ǰ�߳�ֻ��ִ��wait()ʱ�������ѵ��̲߳ű�������ִ��
				this.wait();
				System.out.println("������        �ȴ�����������ͷ����ȴ�֮���ִ��"+pic);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������:"+pic);
		//�������
		this.pic =pic;

		//֪ͨ����
		this.notify();
		//������ͣ��
		this.flag =false;
	}

	public synchronized void watch() {
		if(flag) { //�����ߵȴ�
			try {
				//
				System.out.println("��������Ҫ�ȴ����ȴ�ǰ"+pic);
				this.wait();
				//��������ּ����֤wait()��Ĵ����ǻᱻִ�е�
				System.out.println("�Ҳ���Ҫ�ȴ��ˣ��Ѿ��������ˣ���������*************"+pic);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������"+pic);
		//�������

		//֪ͨ����
		this.notifyAll();
		//����ֹͣ
		this.flag=true;
		//order++;
	}
}

/**
 * ������
 * @author Administrator
 *
 */
class Player implements Runnable {
	private Movie m ;

	public Player(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			//int j = i + 1 ;
			//System.out.println("�����ߵ� "+j+" ��ִ��");
			if(0==i%2) {
				m.play("������"+i );
			} else {
				m.play("�Ұ׻�"+i);
			}
		}
	}
}

class Watcher implements Runnable {
	private Movie m ;

	public Watcher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			int j = i + 1 ;
			//System.out.println("�����ߵ� "+j+" ��ִ��");
			m.watch();
		}
	}
}
