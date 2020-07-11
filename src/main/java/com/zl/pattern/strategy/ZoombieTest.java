package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class ZoombieTest {

	public static void main(String[] args) {
		Zombie zombie = new NomalZombie();
		zombie.move();
		zombie.attack();
		zombie.setAttackable(new KickAttack());
		zombie.attack();

		Zombie zombie1 = new DancerZoombie();
		zombie1.move();
		zombie1.attack();
		zombie1.setMoveable(new StepByStepMove());
		zombie1.move();
	}

}
