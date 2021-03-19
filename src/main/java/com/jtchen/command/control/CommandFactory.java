package com.jtchen.command.control;

import com.jtchen.command.control.beans.CeilingFan;
import com.jtchen.command.control.beans.GarageDoor;
import com.jtchen.command.control.beans.Light;
import com.jtchen.command.control.beans.Stereo;
import com.jtchen.command.control.command.Command;
import com.jtchen.command.control.command.impl.*;

import static com.jtchen.command.control.RemoteControl.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 11:56
 */
public class CommandFactory {


	public static Command[] createCommand(String s) {
		switch (s) {
			case LIVING_ROOM_LIGHT:
				Light light = new Light("Living room");
				return new Command[]{new LightOnCommand(light), new LightOffCommand(light)};
			case LIVING_ROOM_FAN:
				CeilingFan fan = new CeilingFan("Living room");
				return new Command[]{new CeilingFanOnCommand(fan), new CeilingFanOffCommand(fan)};
			case KITCHEN_LIGHT:
				Light light1 = new Light("Kitchen");
				return new Command[]{new LightOnCommand(light1), new LightOffCommand(light1)};
			case GARAGE_DOOR:
				GarageDoor door = new GarageDoor("");
				return new Command[]{new GarageDoorUpCommand(door), new GarageDoorDownCommand(door)};
			case STEREO:
				Stereo stereo = new Stereo("Living room");
				return new Command[]{new StereoOnWithCDCommand(stereo), new StereoOffWithCDCommand(stereo)};
			case MACRO:
				light = new Light("Living room");
				fan = new CeilingFan("Living room");
				light1 = new Light("Kitchen");
				door = new GarageDoor("");
				stereo = new Stereo("Living room");
				Command[] commands = {new LightOnCommand(light), new CeilingFanOnCommand(fan), new LightOnCommand(light1), new GarageDoorUpCommand(door), new StereoOnWithCDCommand(stereo)};

				return new Command[]{new MacroCommand(commands), new NoCommand()};
			default:
				return new Command[]{new NoCommand(), new NoCommand()};
		}
	}
}
