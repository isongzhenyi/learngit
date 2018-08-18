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
 * 处理文件的上传和下载
 * @author Logic Luo
 */
public class ServerThread extends Thread {
	private Socket socket = null;
	// 用于接受送客户端传来的文件
	private DataInputStream dataInputStreamReceive = null;

	// 用于向服务器写文件
	private DataOutputStream dataOutputStreamReceive = null;
	
	//用于向客户端发送文件时读取服务器文件的内容
	private DataInputStream dataInputStreamUpload = null;
	
	//用于向客户端发送文件时，向socket写入文件
	private DataOutputStream dataOutputStreamUpload = null; 
	/**
	 * 默认无参构造函数
	 */
	public ServerThread() {}

	/**
	 * 以socket为参数的构造函数
	 * @param socket
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	
	/**
	 * 服务器端开始程序
	 * @throws IOException
	 */
	@Override
	public void run() {
		// 创建服务器端ServerSocket
		try {
			dataInputStreamReceive = new DataInputStream(new BufferedInputStream(
					socket.getInputStream()));
			
			//接收从服务器端传来的标志位是上传还是下载
			int flag = dataInputStreamReceive.readInt();
			//读取传过来的文件名
			String fileName = dataInputStreamReceive.readUTF();
			
			if(0 == flag) {
				receive(fileName, dataInputStreamReceive);
	System.out.println("服务器端接收数据完成");
				dataInputStreamReceive.close();
			} else {
				dataOutputStreamUpload = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				upload(fileName, dataOutputStreamUpload);
				dataInputStreamUpload.close();
	System.out.println("服务器端上传数据完成");
				dataInputStreamReceive.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭socket
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
	 * 接收从客户端传过来的文件
	 * @param fileName 服务器端文件名称
	 * @param dataInputStreamReceive 从socket接收数据的输入流
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
		System.out.println("文件上传成功");
	}
	
	/**
	 * 从服务器端向客户端发送文件
	 * @param fileName 本地文件名
	 * @param dataOutputStreamUpload 向socket发送数据的输出流
	 * @throws IOException
	 */
	public void upload(String fileName, DataOutputStream dataOutputStreamUpload) throws IOException {
		dataInputStreamUpload = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(Constant.SERVERFOLDER + fileName))));
		Transmission transmission = new Transmission(dataInputStreamUpload, dataOutputStreamUpload);
		transmission.transmitData();
		dataInputStreamUpload.close();
	}
	
}
