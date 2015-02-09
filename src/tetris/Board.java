package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Board extends Canvas{
	
	public static final int CELL = 30;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 600;
	
	private int i = 0;
	
	public Board() {
		super();
		initialize();
	}

	private void initialize() {
		setSize((int) WIDTH, (int) HEIGHT);
		setBackground(Color.orange);
	}
	
	public void paint(Graphics g) {
		//TODO cell들을 눈에 보이기 위해 임시로 넣은 코드. 나중에 삭제하기
		for (i = 0; i < HEIGHT / CELL; i++) {
			g.drawLine((int) 0, (int) (i * CELL), (int) (WIDTH), (int) (i * CELL));
		}
		for (i = 0; i < WIDTH / CELL; i++) {
			g.drawLine((int) (i * CELL), (int) 0, (int) (i * CELL),	(int) (HEIGHT));
		}
		for(i=0; i< 4; i++){
			g.setColor(Color.blue);
			g.fillRect(i*CELL, 0, CELL, CELL);			
		}
	}
}
