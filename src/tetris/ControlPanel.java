package tetris;

import block.Block;
import block.BlockFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements KeyListener, Block.DownCheckListener {
	
	//TODO button class 만들기
	//TODO keyClass도 만들기?!?!?
	//TODO gameState를 알려주는 class 만들기

	//TODO block이 바닥에 떨어지면 새로운 block이 나오도록 하기
	//TODO board에 block 쌓고 없애기 만들기
	
	//TODO 각 block 마다 initialize 함수, change 함수 만들기
	//TODO RandomBlock class 만들기
	//TODO cell에 bottomMove 만들기
		
	private GameTimer timer = new GameTimer();
	
	private Board board;
	private Block block;
	
	public ControlPanel() {
		initialize();
	}

	private void initialize() {
		setFocusable( true ); 
		block = BlockFactory.createBlock();

		board = new Board();
		board.setBlock(block);
        board.repaint();

        timer.setBoard(board);
        timer.setBlock(block);
		timer.start();

        block.setDownCheckListener(this);

		add(board);
		addKeyListener(this);
		setBackground(Color.lightGray);
	}
	
	    
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                block.leftMove();
                break;
            case KeyEvent.VK_RIGHT:
                block.rightMove();
                break;
            case KeyEvent.VK_SPACE:
                block.bottomMove();
                break;
            case KeyEvent.VK_DOWN:
                block.downMove();
                break;
            case KeyEvent.VK_UP:
                block.changeShape();
                break;
        }

        board.repaint();
	}

    @Override
    public void arriveBottom() {
        board.addCells(block.getListCells());
        block = BlockFactory.createBlock();
        block.setDownCheckListener(this);
        board.setBlock(block);
        timer.setBlock(block);
    }
}