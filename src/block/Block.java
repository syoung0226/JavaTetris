package block;

import java.awt.Canvas;

public abstract class Block {
	/*
	 * TODO Block 추상클래스 
	 * Block을 상속받는 여러개의 Block 종류 구현하기
	 * Block에서는 공통적으로 쓰이는 매소드를 구현한다. ex) proceed() : 시간이 지나면 한 칸씩 밑으로 가는 매서드
	 * 블럭마다 다르게 동작하는 것들은 추상메소드로 하위 클래스에서 재정의한다.
	 * 예를들어 키보드 위 화살표를 눌렀을 때 바뀌는 모양은 다 제각각이다.
	 */	
	public static final int CELLNUM = 4;
	private Cell[] cells = new Cell[CELLNUM];
	private int i = 0;
	
	public Block(){
	}
	
	public void downMove(){
		for(i=0; i<CELLNUM; i++){
			cells[i].downY();
		}
	}
	public void leftMove(){
	}
	public void rightMove(){
	}
	public void bottomMove(){
	}
	
	public void paintBlock(Canvas canvas){
		//TODO paintCell을 호출하기
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	public abstract void initialize();
	public abstract void changeShape();

}
