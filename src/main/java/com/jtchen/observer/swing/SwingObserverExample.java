package com.jtchen.observer.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/9 12:02
 */
public class SwingObserverExample {

	private JFrame frame;

	public void go() {
		frame = new JFrame();

		JButton button = new JButton("Should I do it? ");

		// 两个观察者
		button.addActionListener(e -> {
			System.out.println("just do it");
		});
		button.addActionListener(e -> {
			System.out.println("don't do it");
		});
		// Set frame properties
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

}
