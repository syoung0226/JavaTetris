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
			super.setInitializeCell(Color.blue, 4, i, i);
		}
	}

	@Override
	public void changeShape() {	
		if(super.getCell(0).getY()!=super.getCell(3).getY()){
			if(super.getCell(3).getX()+ 3 <= (super.edgeRightX)){
				for(int i=1; i < super.getCellsSize(); i++){
					super.setCell(super.getCell(i).getX()+i, super.getCell(0).getY(), i);				
				}				
			}
		}else{
			for(int i=1; i < super.getCellsSize(); i++){
				super.setCell(super.getCell(i).getX()-i, super.getCell(i).getY()-i, i);
			}
		}
	}
}