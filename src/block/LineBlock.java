package block;

import java.awt.Color;

public class LineBlock extends Block{

	private int i = 0;
	
	public LineBlock() {
		super();
		initialize();
	}

	@Override
	public void initialize() {
		for(i=0; i<Block.CELLNUM; i++){
			super.setInitializeCell(Color.blue, 4, i+3, i);
		}
	}

	@Override
	public void changeShape() {
	}

	@Override
	public void bottomMove() {
	}
}
