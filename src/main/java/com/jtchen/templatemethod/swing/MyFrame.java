package com.jtchen.templatemethod.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/22 16:04
 */
public class MyFrame extends JFrame {
	public MyFrame(String title) throws HeadlessException {
		super(title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		setVisible(true);
	}

	// JFrame 的 paint方法就是一个典型的钩子程序
	// 在默认状态下, paint方法是不做事的
	// 我们覆盖了该方法, 让它做事
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		graphics.setFont(new Font("Consolas", Font.BOLD, 40));
		graphics.drawString("just a test", 200, 200);
	}


	public static void main(String[] args) {
		new MyFrame("JT_CHEN's Design pattens");
	}
}
