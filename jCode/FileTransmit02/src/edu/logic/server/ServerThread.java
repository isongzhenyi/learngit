package edu.logic.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import edu.logic.common.Transmission;
import edu.logic.constant.Constant;

/**
 * �����ļ����ϴ�������
 * @author Logic Luo
 */
public class ServerThread extends Thread {
	private Socket socket = null;
	// ���ڽ����Ϳͻ��˴������ļ�
	private DataInputStream dataInputStreamReceive = null;

	// �����������д�ļ�
	private DataOutputStream dataOutputStreamReceive = null;
	
	//������ͻ��˷����ļ�ʱ��ȡ�������ļ�������
	private DataInputStream dataInputStreamUpload = null;
	
	//������ͻ��˷����ļ�ʱ����socketд���ļ�
	private DataOutputStream dataOutputStreamUpload = null; 
	/**
	 * Ĭ���޲ι��캯��
	 */
	public ServerThread() {}

	/**
	 * ��socketΪ�����Ĺ��캯��
	 * @param socket
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	
	/**
	 * �������˿�ʼ����
	 * @throws IOException
	 */
	@Override
	public void run() {
		// ������������ServerSocket
		try {
			dataInputStreamReceive = new DataInputStream(new BufferedInputStream(
					socket.getInputStream()));
			
			//���մӷ������˴����ı�־λ���ϴ���������
			int flag = dataInputStreamReceive.readInt();
			//��ȡ���������ļ���
			String fileName = dataInputStreamReceive.readUTF();
			
			if(0 == flag) {
				receive(fileName, dataInputStreamReceive);
	System.out.println("�������˽����������");
				dataInputStreamReceive.close();
			} else {
				dataOutputStreamUpload = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				upload(fileName, dataOutputStreamUpload);
				dataInputStreamUpload.close();
	System.out.println("���������ϴ��������");
				dataInputStreamReceive.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//�ر�socket
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ���մӿͻ��˴��������ļ�
	 * @param fileName ���������ļ�����
	 * @param dataInputStreamReceive ��socket�������ݵ�������
	 * @throws IOException
	 */
	public void receive(String fileName, DataInputStream dataInputStreamReceive) throws IOException {
		String filePath = Constant.SERVERFOLDER + fileName;
		dataOutputStreamReceive = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(new File(filePath))));
		Transmission transmission = new Transmission(dataInputStreamReceive,
				dataOutputStreamReceive);
		transmission.transmitData();
		dataOutputStreamReceive.close();
		System.out.println("�ļ��ϴ��ɹ�");
	}
	
	/**
	 * �ӷ���������ͻ��˷����ļ�
	 * @param fileName �����ļ���
	 * @param dataOutputStreamUpload ��socket�������ݵ������
	 * @throws IOException
	 */
	public void upload(String fileName, DataOutputStream dataOutputStreamUpload) throws IOException {
		dataInputStreamUpload = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(Constant.SERVERFOLDER + fileName))));
		Transmission transmission = new Transmission(dataInputStreamUpload, dataOutputStreamUpload);
		transmission.transmitData();
		dataInputStreamUpload.close();
	}
	
}
