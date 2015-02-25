package block;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import tetris.Board;

public abstract class Block {

	private final int CELLNUM = 4;
	private final int edgeLeftX = 0;
	private final int edgeBottomY = (Board.HEIGHT/Board.CELL)-1;
	protected final int edgeRightX = (Board.WIDTH/Board.CELL)-1;
	
	private Cell[] cells = new Cell[CELLNUM];
	private List<Cell> fillBlockCells = new ArrayList<Cell>();

	private DownCheckListener listener;

	public Block(){	}
	
	public abstract void initialize();
	public abstract void changeShape();
	
	public void bottomMove(){
		int tmp = 0;
		for(Cell cell : cells){
			tmp = (tmp < cell.getY() ? cell.getY():tmp);
		}
		
		tmp = edgeBottomY - tmp;
		for(Cell cell : cells){
			cell.bottomDown(tmp);
		}
	};

	public void downMove(){
		if(checkDown()){
            for (Cell cell : cells) {
                cell.downY();
            }
		} else if(listener != null) {
            listener.arriveBottom();
        }
	}
	public void leftMove(){
		if(checkLeft()){
            for (Cell cell : cells) {
                cell.leftX();
            }
		}
	}
	public void rightMove(){
		if(checkRight()){
            for (Cell cell : cells) {
                cell.rigtX();
            }
		}
	}
		
	private boolean checkLeft(){
		for(Cell cell:cells){
			if(cell.getX() == edgeLeftX) return false;

			//
			for(Iterator<Cell> it = fillBlockCells.iterator();it.hasNext();){
	        	Cell value = it.next();
	        	if((cell.getY() == value.getY()) && (cell.getX()-1 == value.getX()))return false;
	        }
			//
			
		}
		return true;
	}

	private boolean checkRight(){
		for(Cell cell:cells){
			if(cell.getX() == edgeRightX) return false;
			
			//
	        for(Iterator<Cell> it = fillBlockCells.iterator();it.hasNext();){
	        	Cell value = it.next();
	        	if((cell.getY() == value.getY()) && (cell.getX()+1 == value.getX())) return false;
	        }
	        //
	        
		}
		return true;
	}

	private boolean checkDown(){
		for(Cell cell:cells){
			if(cell.getY() == edgeBottomY) return false;
	        
			//
			for(Iterator<Cell> it = fillBlockCells.iterator();it.hasNext();){
	        	Cell value = it.next();
	        	if((cell.getX() == value.getX()) && (cell.getY()+1 == value.getY())) return false;
	        }
			//
			
		}
		return true;
	}

	public void setInitializeCell(Color color, int x, int y, int index){
		this.cells[index] = new Cell(color, x, y);
	}
	
	public void setCell(int x, int y, int index){
		this.cells[index].setX(x);
		this.cells[index].setY(y);
	}
	
	public void paintBlock(Graphics g){
        for (Cell cell : cells) {
            cell.paintCell(g);
        }
	}

    public java.util.List<Cell> getListCells() {
        return Arrays.asList(cells);
    }
    
    public Cell getCell(int index){
    	return cells[index];
    }
    
	public int getCellsSize() {
		return cells.length;
	}

    public void setDownCheckListener(DownCheckListener l) {
        listener = l;
    }

    public interface DownCheckListener {
        public void arriveBottom();
    }
    
	public void setFillBlockCells(List<Cell> fillBlockCells){
		this.fillBlockCells = fillBlockCells;
	}

}