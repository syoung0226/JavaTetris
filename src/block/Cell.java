package block;

import java.awt.Color;

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
	
	public void leftX(){this.x-=1;}
	public void downY(){this.y+=1;}
	public void rigtX() {this.x+=1;}
	
	public void bottom(){this.y=19;}
}
