package com.zl.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/9
 */
public class SocketSample {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			final int flag = i;
			new Thread(() -> {
				try (Socket socket = new Socket("127.0.0.1", 9000);) {
					OutputStream out = socket.getOutputStream();
					out.write(("hello server " + flag).getBytes());
					out.flush();
					InputStream in = socket.getInputStream();
					int len = 0;
					while (len == 0) {
						len = in.available();
					}
					byte[] bytes = new byte[len];
					in.read(bytes);
					System.out.println("服务端的回复：" + new String(bytes, "UTF-8"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}

	}

}
