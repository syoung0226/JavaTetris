package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import block.Block;

public class GameTimer implements ActionListener{
	private Timer timer;
	private Block randomNewBlock = null;
	private Board gameBoard = null;
	
	public GameTimer() {
		initialize();
	}
	
	private void initialize(){
		timer = new Timer(400, this);
	}

	public void setBlockBoard(Block block, Board board){
		this.randomNewBlock = block;
		this.gameBoard = board;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(randomNewBlock!=null && gameBoard !=null){
			randomNewBlock.downMove();
			randomNewBlock.paintBlock(gameBoard);
		}
	}
	
	public void timerStart() {
		timer.start();
	}
	public void timerStop(){
		timer.stop();
	}

}
