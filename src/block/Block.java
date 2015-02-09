package block;

import java.awt.Color;

public abstract class Block {

	public static final int CELLNUM = 4;
	private Cell[] cells = new Cell[CELLNUM];
	private int i = 0;
	
	public Block(){	}
	
	public void downMove(){
		for(i=0; i<CELLNUM; i++){
			cells[i].downY();
		}
	}
	public void leftMove(){
		for(i=0; i<CELLNUM; i++){
			cells[i].leftX();
		}	
	}
	public void rightMove(){
	}
	public void bottomMove(){
	}
		
	public Cell[] getCells() {
		return cells;
	}

	public void setCell(Color color, int x, int y, int index){
		this.cells[index] = new Cell(color, x, y);
	}
	
	public abstract void initialize();
	public abstract void changeShape();

}