package com.zl.pattern.factory;

import com.zl.pattern.factory.bean.IAirConditioner;
import com.zl.pattern.factory.bean.IWashingMachine;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public interface IFactory {
	IAirConditioner createAirConditioner();

	IWashingMachine createWashingMachine();
}
