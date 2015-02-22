package block;

import java.awt.Color;

public class JBlock extends Block{
	
	public JBlock() {
		super();
		initialize();
	}
	
	@Override
	public void initialize() {
		super.setInitializeCell(Color.cyan, 6, 0, 0);
		for(int i=1; i< super.getCellsSize(); i++){
			super.setInitializeCell(Color.cyan, 3+i, 1, i);
		}
	}

	@Override
	public void changeShape() {
	}

}
