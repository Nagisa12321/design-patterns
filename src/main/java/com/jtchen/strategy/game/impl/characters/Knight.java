package com.jtchen.strategy.game.impl.characters;

import com.jtchen.strategy.game.Character;
import com.jtchen.strategy.game.impl.behaviors.AxeBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 15:05
 */
public class Knight extends Character {
	public Knight() {
		super(new AxeBehavior());
	}
}
