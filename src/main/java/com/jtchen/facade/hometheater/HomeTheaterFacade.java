package com.jtchen.facade.hometheater;

import com.jtchen.facade.hometheater.equipment.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 10:17
 */
public class HomeTheaterFacade {
	// ���Ǵ���һ����ΪHomeTheaterFacade������
	// �������Ⱪ¶�˼����򵥷���, ����watchMovie()

	// �����۽���ͥӰԺ����������Ϊһ����ϵͳ, ͨ���������
	// ��ϵͳ, ��ʵ��watchMovie����

	// �ͻ����Ե��������ͥӰԺ����ṩ�ķ���, �����ص���
	// ��ϵͳ�ķ���. ������Ҫ����Ӱ, ����ֻ�����watchMovie()
	// ��������

	// ���ֻ���ṩ�����ֱ�ӵĲ���
	// ��δ��ԭ������ϵͳ�������
	// �������Ҫ��ϵͳ�ĸ��Ӹ߼��Ĺ���, ���ǿ���ʹ��ԭ������ϵͳ

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
