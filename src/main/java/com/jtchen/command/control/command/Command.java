package com.jtchen.command.control.command;

import java.io.Serializable;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 10:48
 */
public interface Command extends Serializable {

	// �������������ʵ����ͬ�İ���һ�������Ľӿ�;
	void execute();

	// ����execute����Ϊ
	void undo();
}
