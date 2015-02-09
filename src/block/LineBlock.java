package block;

import java.awt.Color;

public class LineBlock extends Block{

	private Cell[] cells = new Cell[4];
	private int i = 0;
	
	public LineBlock() {
		super();
		initialize();
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		for(i=0; i<Block.CELLNUM; i++){
			cells[i] = new Cell(Color.blue, i+3,0);
		}
		super.setCells(cells);
	}

	@Override
	public void changeShape() {
		// TODO Auto-generated method stub
		
	}

}
