package com.zl.pattern.proxy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
public class Client {

	public static void main(String[] args) {
		Proxy proxy = new Proxy(new RealSubject());
		proxy.request();
	}

}
