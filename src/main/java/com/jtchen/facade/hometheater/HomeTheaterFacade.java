package com.jtchen.facade.hometheater;

import com.jtchen.facade.hometheater.equipment.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 10:17
 */
public class HomeTheaterFacade {
	// 我们创建一个名为HomeTheaterFacade的新类
	// 这个类对外暴露了几个简单方法, 例如watchMovie()

	// 这个外观将家庭影院的诸多组件视为一个子系统, 通过调用这个
	// 子系统, 来实现watchMovie方法

	// 客户可以调用这个家庭影院外观提供的方法, 而不必调用
	// 子系统的方法. 所以想要看电影, 我们只需调用watchMovie()
	// 方法即可

	// 外观只是提供你更加直接的操作
	// 并未将原来的子系统阻隔起来
	// 如果你需要子系统的更加高级的功能, 还是可以使用原来的子系统

	private final Amplifier amplifier;
	private final Tuner tuner;
	private final CdPlayer cdPlayer;
	private final Projector projector;
	private final TheaterLights lights;
	private final Screen screen;
	private final PopcornPopper popper;

	public HomeTheaterFacade(Amplifier amplifier,
							 Tuner tuner,
							 CdPlayer cdPlayer,
							 Projector projector,
							 TheaterLights lights,
							 Screen screen,
							 PopcornPopper popper) {
		this.amplifier = amplifier;
		this.tuner = tuner;
		this.cdPlayer = cdPlayer;
		this.projector = projector;
		this.lights = lights;
		this.screen = screen;
		this.popper = popper;
	}

	public void watchMovie() {
		System.out.println("Get ready to watch a movie.....");
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setSurroundSound();
		amplifier.setVolume(5);
		cdPlayer.on();
		cdPlayer.play("movie");
	}


	public void endMovie() {
		System.out.println("Shutting movie theater dwon...");
		// ....

	}


	public static void main(String[] args) {
		// ....
		// just test watch a moive
	}
}
