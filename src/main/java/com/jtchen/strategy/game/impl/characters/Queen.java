package com.jtchen.strategy.game.impl.characters;

import com.jtchen.strategy.game.Character;
import com.jtchen.strategy.game.impl.behaviors.BowAndArrowBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 15:06
 */
public class Queen extends Character {
	public Queen() {
		super(new BowAndArrowBehavior());
	}
}
