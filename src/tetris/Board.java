package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import block.Block;
import block.Cell;

@SuppressWarnings("serial")
public class Board extends Canvas{
	
	public static final int CELL = 30;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 600;
	
	private int i = 0;
	
	private Block block;
	private Cell blockCells[];
	
	//TODO 바닥으로 떨어진 Cell은 fillCell에 채워져 색칠 되기 
//	private Cell fillCell[];
	
	public Board() {
		super();
		initialize();
	}

	private void initialize() {
		setSize((int) WIDTH, (int) HEIGHT);
		setBackground(Color.orange);
		block = null;
	}
	
	public void setBlock(Block block){
		this.block = block;
	}
	
	public void paint(Graphics g) {
		for (i = 0; i < HEIGHT / CELL; i++) {
			g.drawLine((int) 0, (int) (i * CELL), (int) (WIDTH), (int) (i * CELL));
		}
		for (i = 0; i < WIDTH / CELL; i++) {
			g.drawLine((int) (i * CELL), (int) 0, (int) (i * CELL),	(int) (HEIGHT));
		}
		if(block != null){
			blockCells = block.getCells();
			for(i=0; i< blockCells.length; i++){
				g.setColor(blockCells[i].getColor());
				g.fillRect(blockCells[i].getX()*CELL, blockCells[i].getY()*CELL, CELL, CELL);
			}			
		}
	}
}
