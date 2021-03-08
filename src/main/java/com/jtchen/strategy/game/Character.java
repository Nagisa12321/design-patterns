package com.jtchen.strategy.game;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 14:58
 */
public abstract class Character {
	private WeaponBehavior weapon;

	public void fight() {
		weapon.useWeapon();
	}

	public Character(WeaponBehavior weapon) {
		this.weapon = weapon;
	}

	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}
}
