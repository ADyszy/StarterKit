package com.capgemini.gameOfLife;

public class GameOFLife {
	World world;
	boolean lifeEnded = false;

	public GameOFLife(int xSize, int ySize) {
		world = new World(xSize, ySize); 
	}

	public void lifeStep() {
		lifeEnded = true;
		for (Cell cell : world.getCells())
			if(cell.checkIfAliveAtNextStep())
				lifeEnded = false;
		for (Cell cell : world.getCells())
			cell.update();
	}

	public static void runGameOfLife() throws InterruptedException {
		GameOFLife gof = new GameOFLife(100, 100);
		while (true) {
			gof.lifeStep();
			Thread.sleep(100);
		}
	}

	public void initWithRandomState() {
		for (Cell cell : world.getCells())
			cell.alive(Math.random() < 0.5);// true - false
	}

}
