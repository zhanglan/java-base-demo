package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.GeliAirConditioner;
import com.zl.pattern.factory.bean.GeliWashingMachine;
import com.zl.pattern.factory.bean.IAirConditioner;
import com.zl.pattern.factory.bean.IWashingMachine;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class GeliFactory implements IFactory {
	@Override
	public IAirConditioner createAirConditioner() {
		return new GeliAirConditioner();
	}

	@Override
	public IWashingMachine createWashingMachine() {
		return new GeliWashingMachine();
	}
}
