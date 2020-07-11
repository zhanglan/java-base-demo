package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.HaierAirConditioner;
import com.zl.pattern.factory.bean.HaierWashingMachine;
import com.zl.pattern.factory.bean.IAirConditioner;
import com.zl.pattern.factory.bean.IWashingMachine;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class HaierFactory implements IFactory {
	@Override
	public IAirConditioner createAirConditioner() {
		return new HaierAirConditioner();
	}

	@Override
	public IWashingMachine createWashingMachine() {
		return new HaierWashingMachine();
	}
}
