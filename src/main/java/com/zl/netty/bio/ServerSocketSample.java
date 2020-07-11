package com.zl.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/9
 */
public class ServerSocketSample {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9000);

		while (true) {
			System.out.println("等待客户端连接...");
			Socket socket = serverSocket.accept();
			System.out.println("客户端已经连接:" + socket.getRemoteSocketAddress().toString());
			new Thread(new Runnable() {
				@Override
				public void run() {
					handle(socket);
				}
			}).start();
		}

	}

	private static void handle(Socket socket) {
		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			int len = 0;
			while (len == 0) {
				len = in.available();
			}
			byte[] bytes = new byte[len];
			in.read(bytes);
			System.out.println("服务端接收的数据：" + new String(bytes, "UTF-8"));
			out.write("hello 客户端".getBytes());
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
