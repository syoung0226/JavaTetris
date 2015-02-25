package tetris;

import block.Block;
import block.BlockFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements KeyListener, Block.DownCheckListener {
	
	//TODO 1. block끼리 겹치지 않도록 만들기
	//TODO 2. 각 block 마다  change 함수 만들기

	//TODO 3. board에 block 쌓고 없애기 만들기
		
	//TODO 추가로 할 것
	//TODO button class 만들기
	//TODO keyClass도 만들기
	//TODO gameState를 알려주는 class 만들기
	
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
        
        block.setFillBlockCells(board.getFillBlockCells());

    }
}