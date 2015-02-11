package tetris;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import block.Block;
import block.LineBlock;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener, KeyListener{

	private Button startEndBtn = new Button("start");
	private Button pauseResumeBtn = new Button("pause");
	
	private Board tetrisBoard  = new Board();	
	private Timer timer;
	private Block block;
	
	private int gameState; 
	private static final int running = 0;
	private static final int stop = 1;
	
	public ControlPanel() {
		super();
		initialize();
	}

	private void initialize() {
		setFocusable( true ); 
		timer = new Timer(400, this);
		timer.start();

		gameState = running;
		//TODO 랜덤으로 block을 생성
		block = new LineBlock();
		paintBlock();

		startEndBtn.addActionListener(this);
		pauseResumeBtn.addActionListener(this);

		add(startEndBtn, "West");
		add(pauseResumeBtn, "West");		
		add(tetrisBoard, "East");
		
		setBackground(Color.lightGray);
		addKeyListener(this);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			block.downMove();
			paintBlock();
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
	    
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			block.leftMove();
			paintBlock();
			System.out.println("LEFT");
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			block.rightMove();
			paintBlock();
			System.out.println("RIGHT");
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			block.bottomMove();
			paintBlock();
			System.out.println("BOTTOM");
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			block.downMove();
			paintBlock();
			System.out.println("DOWN");
		}
		
	}
	
	
	private void timerStart() {
		timer.start();
	}
	private void timerStop(){
		timer.stop();
	}
	
	private void paintBlock(){
		tetrisBoard.setBlock(block);
		tetrisBoard.repaint();		
	}
}