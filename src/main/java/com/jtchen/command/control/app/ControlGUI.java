package com.jtchen.command.control.app;

import com.jtchen.command.control.CommandFactory;
import com.jtchen.command.control.RemoteControl;
import com.jtchen.command.control.command.Command;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import static com.jtchen.command.control.RemoteControl.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 12:29
 */
public class ControlGUI {

	private JPanel panel1;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JButton offButton;
	private JButton onButton;
	private JButton offButton6;
	private JButton onButton6;
	private JButton offButton5;
	private JButton onButton5;
	private JButton offButton4;
	private JButton onButton4;
	private JButton offButton3;
	private JButton onButton3;
	private JButton offButton2;
	private JButton onButton2;
	private JButton offButton1;
	private JButton onButton1;
	private JButton undoButton;
	private JButton setCommandButton;
	private final RemoteControl control;

	public ControlGUI() {
		control = new RemoteControl();
		setCommandButton.addActionListener(e -> {
			setCommandButton();
		});
		onButton.addActionListener(e -> control.onCommandWasPushed(0));
		offButton.addActionListener(e -> control.offCommandWasPushed(0));
		onButton1.addActionListener(e -> control.onCommandWasPushed(1));
		offButton1.addActionListener(e -> control.offCommandWasPushed(1));
		onButton2.addActionListener(e -> control.onCommandWasPushed(2));
		offButton2.addActionListener(e -> control.offCommandWasPushed(2));
		onButton3.addActionListener(e -> control.onCommandWasPushed(3));
		offButton3.addActionListener(e -> control.offCommandWasPushed(3));
		onButton4.addActionListener(e -> control.onCommandWasPushed(4));
		offButton4.addActionListener(e -> control.offCommandWasPushed(4));
		onButton5.addActionListener(e -> control.onCommandWasPushed(5));
		offButton5.addActionListener(e -> control.offCommandWasPushed(5));
		onButton6.addActionListener(e -> control.onCommandWasPushed(6));
		offButton6.addActionListener(e -> control.offCommandWasPushed(6));

		textField1.setText(LIVING_ROOM_LIGHT);
		textField4.setText(LIVING_ROOM_FAN);
		textField6.setText(KITCHEN_LIGHT);
		textField7.setText(GARAGE_DOOR);
		textField5.setText(STEREO);

		setCommandButton();
		undoButton.addActionListener(e -> control.undoCommandWasPushed());
	}

	private void setCommandButton() {
		JTextField[] textFields = {textField1, textField4, textField6, textField7, textField5, textField3, textField2};
		for (int i = 0; i < 7; i++) {
			String text = textFields[i].getText();
			Command[] command1 = CommandFactory.createCommand(text);
			control.setCommand(i, command1[0], command1[1]);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("ControlGUI");
		frame.setContentPane(new ControlGUI().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
