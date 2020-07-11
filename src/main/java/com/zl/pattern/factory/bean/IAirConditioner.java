package com.zl.pattern.factory.bean;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public interface IAirConditioner {
	/**
	 * 制冷
	 */
	void becomeCold();

	/**
	 * 制热
	 */
	void becomeHot();
}
