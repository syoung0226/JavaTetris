package block;

import java.awt.Color;

public class TBlock extends Block{

	public TBlock() {
		super();
		initialize();
	}
	
	@Override
	public void initialize() {
		super.setInitializeCell(Color.gray, 5, 0, 0);
		
		for(int i=0; i< super.getCellsSize()-1; i++){
			super.setInitializeCell(Color.gray, 4+i, 1, 1+i);
		}
	}
	@Override
	public void changeShape() {
	}
}
