package com.jtchen.command.control;

import com.jtchen.command.control.command.Command;
import com.jtchen.command.control.command.impl.NoCommand;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 11:43
 */
public class RemoteControl {

	public static final String LIVING_ROOM_LIGHT = "Living room light";
	public static final String LIVING_ROOM_FAN = "Living room fan";
	public static final String KITCHEN_LIGHT = "Kitchen light";
	public static final String GARAGE_DOOR = "Garage door";
	public static final String STEREO = "Living room stereo";
	public static final String MACRO = "Macro";

	private final Command[] onCommands;
	private final Command[] offCommands;
	private final Stack<Command> stack;

	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		stack = new Stack<>();

		for (int i = 0; i < 7; i++) {
			onCommands[i] = new NoCommand();
			offCommands[i] = new NoCommand();
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onCommandWasPushed(int slot) {
		onCommands[slot].execute();
		stack.push(onCommands[slot]);
	}

	public void offCommandWasPushed(int slot) {
		offCommands[slot].execute();
		stack.push(offCommands[slot]);
	}

	public void undoCommandWasPushed() {
		if (!stack.isEmpty()) {
			Command command = stack.pop();
			command.undo();
		}
	}


}
