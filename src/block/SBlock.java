package block;

import java.awt.Color;

public class SBlock extends Block{

	public SBlock() {
		super();
		initialize();
	}
	
	@Override
	public void initialize() {
		for(int i=0; i< super.getCellsSize()/2; i++){
			super.setInitializeCell(Color.pink, 4+i, 1, 0+i);
			super.setInitializeCell(Color.pink, 5+i, 0, 2+i);
		}
	}

	@Override
	public void changeShape() {
	}

}
