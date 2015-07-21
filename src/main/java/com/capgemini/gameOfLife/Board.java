package com.capgemini.gameOfLife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

public class Board extends JPanel{

	private static final long serialVersionUID = -4537822139146908328L;
	int xSize;
	int ySize;
	int rectSize;
	private List<Cell> cells;
	 
	public Board(int longerFrameSide, int xSize, int ySize, List<Cell> cells) {
		this.cells = cells;		
		this.xSize = xSize;
		this.ySize = ySize;
		this.rectSize = (int) Math.round((double)longerFrameSide/(double)xSize);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		int index = 0;
		for (int i = 0; i < ySize; i++)
			for (int j = 0; j < xSize; j++){
				g2d.setColor( cells.get(index).isAlive()? Color.DARK_GRAY : Color.WHITE );
				g2d.fillRect(j*rectSize, i*rectSize, rectSize-1, rectSize-1);
				index++;
			}
	}

}
