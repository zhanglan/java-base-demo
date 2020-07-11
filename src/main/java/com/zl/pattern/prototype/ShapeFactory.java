package com.zl.pattern.prototype;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
public class ShapeFactory {
	private ConcurrentHashMap<String, Shape> prototypeMap = new ConcurrentHashMap<String, Shape>();

	public ShapeFactory() {
		prototypeMap.put("1", new Circle());
		prototypeMap.put("2", new Square());
		prototypeMap.put("3", new Triangle());
	}

	public Shape getShape(String type) {
		if (prototypeMap.containsKey(type)) {
			return prototypeMap.get(type).clone();
		}
		return null;
	}
}
