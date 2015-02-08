import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tetris.Board;
import tetris.ControlPanel;
import tetris.GameStatusInfo;


@SuppressWarnings("serial")
public class TetrisFrame extends JFrame{
	
	JPanel gamePanel = new JPanel();
	ControlPanel controlPanel = new ControlPanel();		
	Board tetrisBoard = new Board();

	public TetrisFrame() {
		super();
		initialize();
	}

	private void initialize() {
		gamePanel.add(tetrisBoard);
		setTitle("Tetris");
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(gamePanel, "West");
		add(controlPanel, "East");
		add(GameStatusInfo.getinstance().getTetrisStatusBar(), BorderLayout.SOUTH);
		setSize((int) (2*Board.WIDTH), (int) (Board.HEIGHT + 50));
		setResizable(false);
		setVisible(true);
	}
}
