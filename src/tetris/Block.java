package tetris;

import java.awt.Canvas;

public class Block {
	enum BlockShape {NoneBlock, SquerBlock, LineBlock, ZBlock, SBlock, LeftLBlock, RightLBlock}
	
	private BlockShape blockShapeName;
	
	public Block(){
		intialize();
	}

	private void intialize() {
		blockShapeName = BlockShape.NoneBlock;
	}
	
	public BlockShape getBloackShapeName(){
		return this.blockShapeName;
	}
	
	//TetrisBlock은 여러 셀을 가지고 있음
	
	private Cell one;
	private Cell two;
	private Cell three;
	private Cell four;
	
	public void paintBlock(Canvas c){
		//printCell
	}
}
