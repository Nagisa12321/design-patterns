package com.jtchen.strategy.game.impl.behaviors;

import com.jtchen.strategy.game.WeaponBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 15:01
 */
public class BowAndArrowBehavior implements WeaponBehavior {
	@Override
	public void useWeapon() {
		System.out.println("Ê¹ÓÃ¹­¼ýÉä»÷");
	}
}
