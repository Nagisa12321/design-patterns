package com.jtchen.strategy.game.impl.characters;

import com.jtchen.strategy.game.Character;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 15:09
 */
public class People extends Character {
	public People () {
		super(() -> System.out.println("用拳击打人"));
	}
}
