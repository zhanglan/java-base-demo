package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class NomalZombie extends Zombie {

	public NomalZombie() {
		this(new StepByStepMove(), new BiteAttack());
	}

	public NomalZombie(Moveable moveable, Attackable attackable) {
		super(moveable, attackable);
	}

	@Override
	void display() {
		System.out.print("普通僵尸...");
	}

}
