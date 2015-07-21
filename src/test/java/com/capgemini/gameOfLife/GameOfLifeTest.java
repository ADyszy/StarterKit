package com.capgemini.gameOfLife;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void particularCellsShouldStayAliveAfterALifeStep() {
		GameOFLife god = new GameOFLife(5, 5);
		CellTest.makeCellsAlive(god.world.getCells(), 6, 7, 12, 8);
		god.lifeStep();
		Assert.assertEquals(true,CellTest.areOnlyCellsWithThisIndexLiving(god.world.getCells(), 2, 6, 7, 8, 11, 12, 13));
	}

	@Test
	public void particularCellsShouldStayAliveAfterSecondLifeStep() {
		GameOFLife god = new GameOFLife(5, 5);
		CellTest.makeCellsAlive(god.world.getCells(), 6, 7, 12, 8);
		god.lifeStep();
		god.lifeStep();
		Assert.assertEquals(true,CellTest.areOnlyCellsWithThisIndexLiving(god.world.getCells(), 1, 2, 3, 11, 13, 17));
	}
}
