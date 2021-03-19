package com.jtchen.command.workingqueue;

import com.jtchen.command.workingqueue.command.Command;
import com.jtchen.command.workingqueue.command.impl.ThreeSumCommand;
import com.jtchen.command.workingqueue.command.impl.TwoSumCommand;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 11:18
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Command> blockingQueue = new LinkedBlockingQueue<>();

		Runnable r = () -> {
			try {
				while (true) {
					Command command = blockingQueue.take();
					command.execute();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread[] threads = new Thread[5];
		for (int i = 0; i < 5; i++) {
			threads[i] = new Thread(r);
		}
		for (int i = 0; i < 5; i++) {
			threads[i].start();
		}


		for (int i = 0; i < 30; i++) {
			TwoSumCommand twoSumCommand = new TwoSumCommand(10000);
			ThreeSumCommand threeSumCommand = new ThreeSumCommand(5000);

			blockingQueue.put(twoSumCommand);
			blockingQueue.put(threeSumCommand);
		}

	}
}
