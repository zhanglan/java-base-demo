package com.zl.pattern.factory.bean;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class HaierAirConditioner implements IAirConditioner {
	@Override
	public void becomeCold() {
		System.out.println("海尔空调制冷...");
	}

	@Override
	public void becomeHot() {
		System.out.println("海尔空调制冷...");
	}
}
