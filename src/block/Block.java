package block;

import java.awt.*;
import java.util.Arrays;

public abstract class Block {
	/*
	 * TODO Cell[0] : 가장 왼쪽 블럭
	 * Cell[1] : 가장 오른쪽 블럭
	 * Cell[3] : 가장 바닥 블럭
	 */
	public static final int CELLNUM = 4;
	public static final int edgeLeftX = 0;
	public static final int edgeBottomY = 19;
	public static final int edgeRightX = 9;
	
	private Cell[] cells = new Cell[CELLNUM];
    private DownCheckListener listener;

	public Block(){	}
	
	public abstract void initialize();
	public abstract void changeShape();
	public abstract void bottomMove();

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
        return cells[0].getX() != edgeLeftX;
	}

	private boolean checkRight(){
        return cells[1].getX() != edgeRightX;
	}

	private boolean checkDown(){
        return cells[3].getY() != edgeBottomY;
	}

	public void setInitializeCell(Color color, int x, int y, int index){
		this.cells[index] = new Cell(color, x, y);
	}
	
	public void paintBlock(Graphics g){
        for (Cell cell : cells) {
            cell.paintCell(g);
        }
	}

    public java.util.List<Cell> getCells() {
        return Arrays.asList(cells);
    }

    public void setDownCheckListener(DownCheckListener l) {
        listener = l;
    }

    public interface DownCheckListener {
        public void arriveBottom();
    }
}