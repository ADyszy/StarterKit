package com.capgemini.gameOfLife;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Visualiser extends JFrame {

	private static final long serialVersionUID = 71841646824517125L;
	private static final int MAX_FRAME_WIDTH = 600;
	private static final int MAX_FRAME_HEIGHT = 600;

	public Visualiser(GameOFLife gameOfLife) {
		super("Game Of Life - fast test");
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(MAX_FRAME_WIDTH, MAX_FRAME_HEIGHT));
		cp.add(new Board(MAX_FRAME_WIDTH, gameOfLife.world.getxSize(), gameOfLife.world.getySize(),
				gameOfLife.world.getCells()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(MAX_FRAME_WIDTH, MAX_FRAME_HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack();
	}

}
