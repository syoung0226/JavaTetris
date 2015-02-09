package tetris;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import block.LineBlock;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener{

	private Button startEndBtn = new Button("start");
	private Button pauseResumeBtn = new Button("pause");
	
	private GameStatus gameStatus = new GameStatus();	
	private Board tetrisBoard  = new Board();
	
	private Timer timer;
	
	private LineBlock lineBlock = new LineBlock();
	
	private int gameState; 
	
	private static final int running = 0;
	private static final int stop = 1;
	
	public ControlPanel() {
		super();
		initialize();
	}

	private void initialize() {
		startEndBtn.addActionListener(this);
		pauseResumeBtn.addActionListener(this);
		add(startEndBtn, "West");
		add(pauseResumeBtn, "West");
		setBackground(Color.lightGray);
		add(gameStatus, "West");
		add(tetrisBoard, "East");
		timer = new Timer(400, this);
		gameState = stop;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			lineBlock.downMove();
			tetrisBoard.setBlock(lineBlock);
			tetrisBoard.repaint();
		}
		
		//TODO gameState 다시 한 번 점검 : 이상한 부분 많음.
		if (gameState == stop && e.getSource() == startEndBtn) {
			timerStart();
			startEndBtn.setLabel("end");
			gameState = running;
		} else if(gameState == running && e.getSource() == startEndBtn){
			//TODO clean board
			timerStop();
			startEndBtn.setLabel("start");
			gameState = stop;
		} else if (gameState == running && e.getSource() == pauseResumeBtn) {
			timerStop();
			pauseResumeBtn.setLabel("resume");
			gameState = stop;
		} else if (gameState == stop && e.getSource() == pauseResumeBtn) {
			timerStart();
			pauseResumeBtn.setLabel("pause");
			gameState = running;
		}
	}
	
	private void timerStart() {
		timer.start();
	}
	private void timerStop(){
		timer.stop();
	}
}