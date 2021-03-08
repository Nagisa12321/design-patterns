package com.jtchen.strategy.game.impl.characters;

import com.jtchen.strategy.game.Character;
import com.jtchen.strategy.game.impl.behaviors.KnifeBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 15:04
 */
public class King extends Character {
	public King() {
		super(new KnifeBehavior());
	}
}
