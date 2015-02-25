package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import block.Block;
import block.Cell;


@SuppressWarnings("serial")
public class Board extends Canvas {
	
	public static final int CELL = 30;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 600;
	
    private Block block;
	private List<Cell> fillBlockCells = new ArrayList<Cell>();
	
	//TODO 수정
	private int line = 0;
	private int tmp = 0;
	//
	
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
            //TODO 수정
            line = (cell.getY() == ((HEIGHT/CELL)-1)) ? line+1 : line;            
            //
        }        
        
        //TODO 수정
        for(Iterator<Cell> it = fillBlockCells.iterator();it.hasNext();){
        	Cell value = it.next();
    		if(line == (WIDTH/CELL) && value.getY()==(HEIGHT/CELL)-1){
    			it.remove();
    			tmp = 1;
    		}
        }
        if(tmp == 1){
			for(Cell cell:fillBlockCells){
				cell.setY(cell.getY()+1);
			}
        }
        tmp = 0;
        line = 0;
        //
	}

    private void paintLine(Graphics g) {
        for (int i = 0; i < HEIGHT / CELL; i++) {
            g.drawLine(0, i * CELL, WIDTH, i * CELL);
        }
        for (int i = 0; i < WIDTH / CELL; i++) {
            g.drawLine(i * CELL, 0, i * CELL, HEIGHT);
        }
    }
    
    public List<Cell> getFillBlockCells(){
		return fillBlockCells;
	}
	
}
