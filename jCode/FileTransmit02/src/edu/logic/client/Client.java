package edu.logic.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import edu.logic.common.Transmission;
import edu.logic.constant.Constant;

/**
 * �ͻ�����
 * @author Logic Luo
 */
public class Client {
	
	//���ڴ��ļ��ж�ȡҪ�ϴ�������
	DataInputStream dataInputStreamUploade = null;
	//������socket��д������
	DataOutputStream dataOutputStreamUploade = null;
	//���ڽ��մ�socket����������
	DataInputStream dataInputStreamReceive = null;
	//������ͻ����ļ���д����
	DataOutputStream dataOutputStreamReceive = null;
	
	/**
	 * �ͻ��˿�ʼ����
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void start() throws UnknownHostException, IOException {
		while(true) {
			System.out.println("�밴�����¸�ʽ��д���\n�ϴ��ļ���put �����ļ��� �������ļ���\n�����ļ���get �������ļ��� �����ļ���");
			String localFileName = null;
			String remoteFileName = null;
			Scanner scanner = new Scanner(System.in);
			String command = scanner.nextLine();
			//�������
			String[] commandArray = command.split(" ");
			Socket socket = null;
			int flag = 0;
			
			//�������
			if(commandArray[0].equals("put")) {
				flag = 0;
				localFileName = commandArray[1];
				remoteFileName = commandArray[2];
			} else {
				flag = 1;
				localFileName = commandArray[2];
				remoteFileName = commandArray[1];
			}
			
			//����socket,��������˷����������� 
			socket = new Socket(Constant.HOSTIP, Constant.PORT);
			
			dataOutputStreamUploade = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			//��������˷����ϴ������ر�־
			dataOutputStreamUploade.writeInt(flag);
			dataOutputStreamUploade.flush();
			//��������˷���Զ���ļ���
			dataOutputStreamUploade.writeUTF(remoteFileName);
			dataOutputStreamUploade.flush();
			if(flag == 0) {
			//��������˷����ļ�����
			put(localFileName, dataOutputStreamUploade);
			dataOutputStreamUploade.close();
System.out.println("�ͻ����ϴ��������");
			} else {
				dataInputStreamReceive = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				get(localFileName, dataInputStreamReceive);
System.out.println("�ͻ������ݽ������");
				dataInputStreamReceive.close();
			}
			dataOutputStreamUploade.close();
			socket.close();
			System.out.println("File transfer complete");
		}
	}
	
	/**
	 * �ӿͻ�����������ϴ�����
	 * @param fileName �ͻ����ļ���
	 * @param dataOutputStreamUploade
	 * @throws IOException
	 */
	public void put(String fileName, DataOutputStream dataOutputStreamUploade) throws IOException {
		File file = new File(Constant.CLIENTFOLDER + fileName);
		//�����ļ�������
		dataInputStreamUploade = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		Transmission transmission = new Transmission(dataInputStreamUploade, dataOutputStreamUploade);
		transmission.transmitData();
		dataInputStreamUploade.close();
	}
	
	/**
	 * �ӷ�������ͻ�����������
	 * @param fileName �ͻ����ļ���
	 * @param dataInputStreamReceive socket�������ݵ�������
	 * @throws IOException
	 */
	public void get(String fileName, DataInputStream dataInputStreamReceive) throws IOException {
		//�����ļ������
		dataOutputStreamReceive = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(Constant.CLIENTFOLDER + fileName))));
		Transmission transmission = new Transmission(dataInputStreamReceive, dataOutputStreamReceive);
		transmission.transmitData();
		dataOutputStreamReceive.close();
		dataInputStreamReceive.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Client().start();
	}
}
