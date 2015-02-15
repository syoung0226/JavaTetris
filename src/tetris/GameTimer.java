package tetris;

import block.Block;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer implements ActionListener{
	private Timer timer;
	private Block block;
	private Board board;

	public GameTimer() {
		initialize();
	}
	
	private void initialize(){
		timer = new Timer(400, this);
	}

    public void setBlock(Block block) {
        this.block = block;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		if(block !=null && board !=null){
			block.downMove();
            board.repaint();
		}
	}
	
	public void start() {
		timer.start();
	}
	public void stop(){
		timer.stop();
	}

}
