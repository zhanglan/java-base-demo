package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class DancerZoombie extends Zombie {

	public DancerZoombie() {
		this(new JumpMove(), new KickAttack());
	}

	public DancerZoombie(Moveable moveable, Attackable attackable) {
		super(moveable, attackable);
	}

	@Override
	void display() {
		System.out.print("舞王僵尸...");
	}

}
