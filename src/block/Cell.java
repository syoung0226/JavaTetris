package block;

import java.awt.Color;

import tetris.Board;

public class Cell {
	private Color color;
	private int x;
	private int y;
	
	public Cell(Color color, int x, int y){
		initialize(color, x, y);
	}
	
	private void initialize(Color color, int x, int y) {
		setColor(color);
		setX(x);
		setY(y);
	}
	
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color = color;}
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	
	public void downY(){
		if(this.y > 18){
			return;
		}else{
			this.y+=1;
		}
	}
	public void leftX(){this.x+=1;}
	
	public void paintCell(Board board){
		//TODO Cell 한 칸을 canvas에 색칠하는 함수
	}
}
