package com.zl.crypto.bls;

import it.unisa.dia.gas.jpbc.PairingParametersGenerator;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeAPairing;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/10
 */
public class Main {

	public static void main(String[] args) {
		PairingParametersGenerator generator = new TypeACurveGenerator(160, 256);
		TypeAPairing pairing = new TypeAPairing(generator.generate());
	}

}
