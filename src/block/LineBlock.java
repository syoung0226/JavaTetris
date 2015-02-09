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
			super.setCell(Color.blue, i+3, 0, i);
		}
	}

	@Override
	public void changeShape() {
	}

}
