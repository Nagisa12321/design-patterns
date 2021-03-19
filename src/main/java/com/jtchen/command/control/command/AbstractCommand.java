package com.jtchen.command.control.command;

import java.io.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 11:39
 */
public abstract class AbstractCommand implements Command {

	// 默认方式最好直接设置为1L,因为java  sdk会自动进行hash计算，
	// 并生成唯一的UID值。手动设置serialVersionUID的好处是当前
	// class如果改变了成员变量，比如增加或者删除之后，这个UID是
	// 不改变的，那么反序列化就不会失败
	private static final long serialVersionUID = 1L;

}
