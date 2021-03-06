package main;
import java.awt.Color;

import javax.swing.JFrame;

import tetris.Board;
import tetris.ControlPanel;


@SuppressWarnings("serial")
public class TetrisFrame extends JFrame{
	
	private ControlPanel controlPanel;		

	public TetrisFrame() {
		super();
		initialize();
	}

	private void initialize() {
		controlPanel = new ControlPanel();
		setTitle("Tetris");
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(controlPanel);		
		setSize((int) (2*Board.WIDTH), (int) (Board.HEIGHT + 40));
		setResizable(false);
		setVisible(true);
	}
}
