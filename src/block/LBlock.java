package block;

import java.awt.Color;

public class LBlock extends Block{
	
	public LBlock() {
		super();
		initialize();
	}
	
	@Override
	public void initialize() {
		super.setInitializeCell(Color.green, 4, 0, 0);
		for(int i=1; i< super.getCellsSize(); i++){
			super.setInitializeCell(Color.green, 3+i, 1, i);
		}
	}

	@Override
	public void changeShape() {
	}
}