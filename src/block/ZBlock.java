package block;

import java.awt.Color;

public class ZBlock extends Block{

	public ZBlock() {
		super();
		initialize();
	}
	
	@Override
	public void initialize() {
		for(int i=0; i< super.getCellsSize()/2; i++){
			super.setInitializeCell(Color.white, 4+i, 0, 0+i);
			super.setInitializeCell(Color.white, 5+i, 1, 2+i);
		}
	}

	@Override
	public void changeShape() {
	}

}