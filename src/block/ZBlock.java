package block;

import java.awt.Color;

public class ZBlock extends Block{

	private int step = 0;
	
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
		switch (step){
		case 0:
			super.setCell(super.getCell(0).getX()+1, super.getCell(0).getY()-1, 0);
			super.setCell(super.getCell(2).getX()-1, super.getCell(2).getY()-1, 2);
			super.setCell(super.getCell(3).getX()-2, super.getCell(3).getY(), 3);
			step = 1;
			break;
		case 1:
			super.setCell(super.getCell(0).getX()-1, super.getCell(0).getY()+1, 0);
			super.setCell(super.getCell(2).getX()+1, super.getCell(2).getY()+1, 2);
			super.setCell(super.getCell(3).getX()+2, super.getCell(3).getY(), 3);
			step = 0;
			break;
		}
	}

}