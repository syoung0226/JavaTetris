package block;

import java.awt.Color;

import tetris.Board;

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
	private int i = 0;
	
	public Block(){	}
	
	public abstract void initialize();
	public abstract void changeShape();
	public abstract void bottomMove();

	public void downMove(){
		if(checkDown()){
			for(i=0; i<CELLNUM; i++){
				cells[i].downY();
			}			
		}
	}
	public void leftMove(){
		if(checkLeft()){
			for(i=0; i<CELLNUM; i++){
				cells[i].leftX();
			}	
		}
	}
	public void rightMove(){
		if(checkRight()){
			for(i=0; i<CELLNUM; i++){
				cells[i].rigtX();
			}	
		}
	}

	private boolean checkLeft(){
		if(cells[0].getX() == edgeLeftX){
			return false;
		}else{
			return true;
		}
	}
	private boolean checkRight(){
		if(cells[1].getX() == edgeRightX){
			return false;
		}else{
			return true;
		}
	}
	public boolean checkDown(){
		if(cells[3].getY() == edgeBottomY){
			return false;
		}else{
			return true;
		}
	}
	
	public Cell[] getCells() {
		return cells;
	}
	public void setCells(Cell[] cells){
		this.cells = cells;
	}

	public void setInitializeCell(Color color, int x, int y, int index){
		this.cells[index] = new Cell(color, x, y);
	}
	
	public void paintBlock(Board board){
		board.setBlock(this);
		board.repaint();
	}
}