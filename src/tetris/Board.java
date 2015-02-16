package tetris;

import block.Block;
import block.Cell;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class Board extends Canvas {
	
	public static final int CELL = 30;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 600;
	
    private Block block;
	private List<Cell> fillBlockCells = new ArrayList<Cell>();

	public Board() {
		super();
		initialize();
	}

	private void initialize() {
		setSize(WIDTH, HEIGHT);
		setBackground(Color.orange);
	}
	
	public void setBlock(Block block){
        this.block = block;
	}

    public void addCells(List<Cell> cells) {
        fillBlockCells.addAll(cells);
    }

	public void paint(Graphics g) {
        paintLine(g);

        block.paintBlock(g);
        for (Cell cell : fillBlockCells) {
            cell.paintCell(g);
        }
	}

    private void paintLine(Graphics g) {
        for (int i = 0; i < HEIGHT / CELL; i++) {
            g.drawLine(0, i * CELL, WIDTH, i * CELL);
        }
        for (int i = 0; i < WIDTH / CELL; i++) {
            g.drawLine(i * CELL, 0, i * CELL, HEIGHT);
        }
    }
}
