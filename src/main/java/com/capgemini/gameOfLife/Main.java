package com.capgemini.gameOfLife;

public class Main {

	private static final int SLEEP_TIME = 50;

	public static void main(String[] args) { 
		GameOFLife gof = new GameOFLife(100, 100);
		Visualiser vis = new Visualiser(gof);
		vis.setVisible(true);

		gof.initWithRandomState();
		while (!gof.lifeEnded) {
			vis.getContentPane().validate(); 
			vis.getContentPane().repaint(); 
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gof.lifeStep();
		}
	}
}
