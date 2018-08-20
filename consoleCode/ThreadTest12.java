
/*
	t1��t2

	�첽���ģ�ͣ�t1�߳�ִ��t1�ģ�t2�߳�ִ��t2�ģ������߳�֮��˭Ҳ����˭��

	ͬ�����ģ�ͣ�t1�̺߳�t2�߳�ִ�У���t1�̱߳����t2�߳�ִ�н���֮��,t1�̲߳���ִ�У�����ͬ�����ģ�͡�


	ʲôʱ��Ҫͬ���أ�ΪʲôҪ�����߳�ͬ���أ�
		1.Ϊ�����ݵİ�ȫ������Ӧ�ó����ʹ���ʽ��ͣ�����Ϊ�˱�֤�����ǰ�ȫ�ģ���������߳�ͬ�����ơ�
		�߳�ͬ������ʹ�������ˣ���ͬ�����̡߳�

		2.ʲô������Ҫʹ���߳�ͬ����
			��һ�������Ƕ��̻߳���
			�ڶ������̻߳�������ͬһ������.
			����������������漰���޸Ĳ�����
	
	���³�����ʾȡ�����ӡ����³���ʹ���߳�ͬ�����ƣ����߳�
	ͬʱ��ͬһ���˻�����ȡ������������ʲô���⣿
*/
public class ThreadTest12
{
	public static void main(String[] args){
		
		//����һ���������˻�
		Account act = new Account("actno-001",4000.0);

		//�����̶߳�ͬһ���˻�ȡ��
		Thread t1 = new Thread(new Processor(act));
		Thread t2 = new Thread(new Processor(act));

		t1.start();

		t2.start();
	}
}

//ȡ���߳�
class Processor implements Runnable
{
	//�˻�
	Account act;

	//Constructor
	Processor(Account act)
	{
		this.act = act;
	}

	public void run(){
		act.withdraw(1000.0);
		System.out.println("ȡ��1000.0�ɹ�����" + act.getBalance());
	}
}

//�˻�
class Account
{
	private String actno;
	private double balance;

	public Account(){}
	public Account(String actno,double balance){
		this.actno = actno;
		this.balance = balance;
	}

	//setter and getter
	public void setActno(String actno){
		this.actno = actno;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}

	public String getActno()
	{
		return actno;
	}

	public double getBalance(){
		return balance;
	}

	//�����ṩһ��ȡ��ķ���
	public void withdraw(double money){ //�Ե�ǰ�˻�����ȡ�����

		double after = balance - money;
		
		//�ӳ�
		try{Thread.sleep(1000);}catch(Exception e){}
		

		//����
		this.setBalance(after);
	}
}