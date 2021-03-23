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

	// JFrame �� paint��������һ�����͵Ĺ��ӳ���
	// ��Ĭ��״̬��, paint�����ǲ����µ�
	// ���Ǹ����˸÷���, ��������
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
