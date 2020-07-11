package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.IAirConditioner;
import com.zl.pattern.factory.bean.IPerson;
import com.zl.pattern.factory.bean.IWashingMachine;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class Client {
	public static void main(String[] args) {
		IFactory factory1 = new GeliFactory();
		IAirConditioner airConditioner1 = factory1.createAirConditioner();
		airConditioner1.becomeCold();
		IWashingMachine washingMachine1 = factory1.createWashingMachine();
		washingMachine1.washClothes();

		IFactory factory2 = new HaierFactory();
		IAirConditioner airConditioner2 = factory2.createAirConditioner();
		airConditioner2.becomeCold();
		IWashingMachine washingMachine2 = factory2.createWashingMachine();
		washingMachine2.washClothes();
	}
}
