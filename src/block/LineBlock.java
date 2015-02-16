package block;

import java.awt.Color;

public class LineBlock extends Block{
	
	public LineBlock() {
		super();
		initialize();
	}

	@Override
	public void initialize() {
		for(int i=0; i< super.getCellsSize(); i++){
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
