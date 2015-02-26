package block;

import java.awt.Color;

public class JBlock extends Block{
	
	private int step = 0;
	
	public JBlock() {
		super();
		initialize();
	}
	
	@Override
	public void initialize() {
		super.setInitializeCell(Color.cyan, 6, 0, 0);
		for(int i=1; i< super.getCellsSize(); i++){
			super.setInitializeCell(Color.cyan, 7-i, 1, i);
		}
	}

	@Override
	public void changeShape() {
		switch (step){
		case 0:
			super.setCell(super.getCell(0).getX()-1, super.getCell(0).getY()+1, 0);
			super.setCell(super.getCell(1).getX()-2, super.getCell(1).getY(), 1);
			super.setCell(super.getCell(2).getX()-1, super.getCell(2).getY()-1, 2);
			super.setCell(super.getCell(3).getX(), super.getCell(3).getY()-2, 3);
			step = 1;
			break;
		case 1:
			super.setCell(super.getCell(0).getX()-1, super.getCell(0).getY(), 0);
			super.setCell(super.getCell(1).getX(), super.getCell(1).getY()-1, 1);
			super.setCell(super.getCell(2).getX()+1, super.getCell(2).getY(), 2);
			super.setCell(super.getCell(3).getX()+2, super.getCell(3).getY()+1, 3);
			step = 2;
			break;
		case 2:
			super.setCell(super.getCell(0).getX()+1, super.getCell(0).getY()-2, 0);
			super.setCell(super.getCell(1).getX()+2, super.getCell(1).getY()-1, 1);
			super.setCell(super.getCell(2).getX()+1, super.getCell(2).getY(), 2);
			super.setCell(super.getCell(3).getX(), super.getCell(3).getY()+1, 3);
			step = 3;
			break;
		case 3:
			super.setCell(super.getCell(0).getX()+1, super.getCell(0).getY()+1, 0);
			super.setCell(super.getCell(1).getX(), super.getCell(1).getY()+2, 1);
			super.setCell(super.getCell(2).getX()-1, super.getCell(2).getY()+1, 2);
			super.setCell(super.getCell(3).getX()-2, super.getCell(3).getY(), 3);
			step = 0;
			break;
		}
	}
}
