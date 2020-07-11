package com.zl.pattern.strategy;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
@Data
public abstract class Zombie {
	Moveable moveable;

	Attackable attackable;

	public Zombie(Moveable moveable, Attackable attackable) {
		setMoveable(moveable);
		setAttackable(attackable);
	}

	abstract void display();

	void move() {
		display();
		moveable.move();
	}

	void attack() {
		display();
		attackable.attack();
	}
}
