package com.zl.pattern.factory.bean;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class GeliAirConditioner implements IAirConditioner {
	@Override
	public void becomeCold() {
		System.out.println("格力空调制冷...");
	}

	@Override
	public void becomeHot() {
		System.out.println("格力空调制热...");
	}
}
