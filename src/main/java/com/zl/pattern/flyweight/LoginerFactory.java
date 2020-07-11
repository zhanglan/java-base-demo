package com.zl.pattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class LoginerFactory {
	private final static Map<String, ILoginer> loginerMap = new ConcurrentHashMap<String, ILoginer>();

	public static ILoginer getLoginer(String token) {
		if (!loginerMap.containsKey(token)) {
			loginerMap.put(token, new ConcreteLoginer(token));
		}
		return loginerMap.get(token);
	}

	public static int getSize() {
		return loginerMap.size();
	}

}
