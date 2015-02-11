package tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import block.Block;
import block.LineBlock;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements KeyListener{
		
	private GameTimer timer;
	
	private Board tetrisBoard;	
	private Block randomNewBlock;
	
	public ControlPanel() {
		super();
		initialize();
	}

	private void initialize() {
		setFocusable( true ); 
		timer = new GameTimer();
		randomNewBlock = new LineBlock();
		tetrisBoard  = new Board();
		
		randomNewBlock.paintBlock(tetrisBoard);
		
		timer.setBlockBoard(randomNewBlock, tetrisBoard);
		timer.timerStart();
		
		add(tetrisBoard);
		addKeyListener(this);
		setBackground(Color.lightGray);
	}
	    
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			randomNewBlock.leftMove();
			randomNewBlock.paintBlock(tetrisBoard);
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			randomNewBlock.rightMove();
			randomNewBlock.paintBlock(tetrisBoard);
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			randomNewBlock.bottomMove();
			randomNewBlock.paintBlock(tetrisBoard);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			randomNewBlock.downMove();
			randomNewBlock.paintBlock(tetrisBoard);
		}		
	}
}