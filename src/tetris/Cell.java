package tetris;

import java.awt.Canvas;
import java.awt.Color;

public class Cell {
	//TODO Cell class가 가져야 할 맴버변수 (Color, 위치정보(x,y))
	private Color cellColor;
	private int cellX;
	private int cellY;
	
	public Cell(Color color, int x, int y){
		initialize(color, x, y);
	}
	
	private void initialize(Color color, int x, int y) {
		setCellColor(color);
		setCellX(x);
		setCellY(y);
	}

	public void paint(Canvas canvas){
		//TODO Cell 한 칸을 canvas에 색칠하는 함수
		
	}

	public Color getCellColor() {
		return cellColor;
	}

	public void setCellColor(Color cellColor) {
		this.cellColor = cellColor;
	}

	public int getCellX() {
		return cellX;
	}

	public void setCellX(int cellX) {
		this.cellX = cellX;
	}

	public int getCellY() {
		return cellY;
	}

	public void setCellY(int cellY) {
		this.cellY = cellY;
	}
}
