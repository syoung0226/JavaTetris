package tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Board extends Canvas{
	
	public static final int CELL = 30;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 600;
	
	public Board() {
		super();
		initialize();
	}

	private void initialize() {
		setSize((int) WIDTH, (int) HEIGHT);
		setBackground(Color.orange);
	}
	
	public void paint(Graphics g) {
		int i;
		for (i = 0; i < HEIGHT / CELL; i++) {
			g.drawLine((int) 0, (int) (i * CELL), (int) (WIDTH), (int) (i * CELL));
		}
		for (i = 0; i < WIDTH / CELL; i++) {
			g.drawLine((int) (i * CELL), (int) 0, (int) (i * CELL),	(int) (HEIGHT));
		}
	}
}
