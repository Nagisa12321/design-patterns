package com.jtchen.command.control.command;

import java.io.Serializable;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 10:48
 */
public interface Command extends Serializable {

	// 让所有命令对象实现相同的包含一个方法的接口;
	void execute();

	// 撤销execute的行为
	void undo();
}
