package com.zl.netty.nio;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/9
 */
public class NIOServer {

	private Selector selector;

	private ServerSocketChannel serverChannel;

	public void initServer() {
		try {
			this.serverChannel = ServerSocketChannel.open();
			this.selector = Selector.open();
			this.serverChannel.configureBlocking(false);
			this.serverChannel.bind(new InetSocketAddress(9000));
			this.serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
			while (true) {
				this.selector.select();
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();
					handle(key);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				this.serverChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handle(SelectionKey key) throws IOException {
		if (key.isAcceptable()) {
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
			SocketChannel socketChannel = serverSocketChannel.accept();
			socketChannel.configureBlocking(false);
			socketChannel.register(this.selector, SelectionKey.OP_READ);
		} else if (key.isReadable()) {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int len = socketChannel.read(buffer);
			if (len != -1) {
				System.out.println("读取到客户端发送来的数据：" + new String(buffer.array(), 0, len));
			}
			ByteBuffer writeBuffer = ByteBuffer.wrap("hello client".getBytes());
			socketChannel.write(writeBuffer);
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		} else if (key.isWritable()) {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			key.interestOps(SelectionKey.OP_READ);
		}
	}

	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer();
	}

}
