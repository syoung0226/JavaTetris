package block;

import java.awt.*;
import java.util.Arrays;

import tetris.Board;

public abstract class Block {

	private final int CELLNUM = 4;
	private final int edgeLeftX = 0;
	private final int edgeBottomY = (Board.HEIGHT/Board.CELL)-1;
	private final int edgeRightX = (Board.WIDTH/Board.CELL)-1;
	
	private Cell[] cells = new Cell[CELLNUM];

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
		}
		return true;
	}

	private boolean checkRight(){
		for(Cell cell:cells){
			if(cell.getX() == edgeRightX) return false;
		}
		return true;
	}

	private boolean checkDown(){
		for(Cell cell:cells){
			if(cell.getY() == edgeBottomY) return false;
		}
		return true;
	}

	public void setInitializeCell(Color color, int x, int y, int index){
		this.cells[index] = new Cell(color, x, y);
	}
	
	public void paintBlock(Graphics g){
        for (Cell cell : cells) {
            cell.paintCell(g);
        }
	}

    public java.util.List<Cell> getListCells() {
        return Arrays.asList(cells);
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
}