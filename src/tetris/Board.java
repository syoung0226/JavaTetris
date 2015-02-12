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
	
	private Cell downBlockCells[];	
	private Cell fillBlockCells[];
	
	public Board() {
		super();
		initialize();
	}

	private void initialize() {
		setSize((int) WIDTH, (int) HEIGHT);
		setBackground(Color.orange);
		downBlockCells = null;
	}
	
	public void setBlock(Block block){
		this.downBlockCells = block.getCells();
	}
	
	public void setFillBlock(Block block){
		this.fillBlockCells = block.getCells();
	}
	
	public void paint(Graphics g) {
		for (i = 0; i < HEIGHT / CELL; i++) {
			g.drawLine((int) 0, (int) (i * CELL), (int) (WIDTH), (int) (i * CELL));
		}
		for (i = 0; i < WIDTH / CELL; i++) {
			g.drawLine((int) (i * CELL), (int) 0, (int) (i * CELL),	(int) (HEIGHT));
		}
		if(downBlockCells != null){
			for(i=0; i< downBlockCells.length; i++){
				g.setColor(downBlockCells[i].getColor());
				g.fillRect(downBlockCells[i].getX()*CELL, downBlockCells[i].getY()*CELL, CELL, CELL);
			}			
		}
		if(fillBlockCells != null){
			for(i=0; i< downBlockCells.length; i++){
				g.setColor(downBlockCells[i].getColor());
				g.fillRect(downBlockCells[i].getX()*CELL, downBlockCells[i].getY()*CELL, CELL, CELL);
			}
		}
	}
}
