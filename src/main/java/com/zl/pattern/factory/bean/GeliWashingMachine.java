package com.zl.pattern.factory.bean;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class GeliWashingMachine implements IWashingMachine {
	@Override
	public void washClothes() {
		System.out.println("格力洗衣机洗衣服...");
	}
}
