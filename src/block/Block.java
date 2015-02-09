package block;

import java.awt.Color;

public abstract class Block {
	/*
	 * TODO Cell[0] : 가장 왼쪽 블럭
	 * Cell[1] : 가장 바닥 블럭
	 * Cell[3] : 가장 오른쪽 블럭
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
	public void bottomMove(){
		for(i=0; i<CELLNUM; i++){
			cells[i].bottom();
		}	
	}

	private boolean checkLeft(){
		if(cells[0].getX() == edgeLeftX){
			return false;
		}else{
			return true;
		}
	}	
	private boolean checkDown(){
		if(cells[1].getY() == edgeBottomY){
			return false;
		}else{
			return true;
		}
	}
	private boolean checkRight(){
		if(cells[3].getX() == edgeRightX){
			return false;
		}else{
			return true;
		}
	}
	
	public Cell[] getCells() {
		return cells;
	}

	public void setCell(Color color, int x, int y, int index){
		this.cells[index] = new Cell(color, x, y);
	}
}