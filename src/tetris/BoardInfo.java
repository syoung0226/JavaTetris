package tetris;


public class BoardInfo {
	
	private static final BoardInfo instance = new BoardInfo();
	
	private BoardInfo(){}
	
	public static BoardInfo getInstance(){
		return instance;
	}
	
	private Board tetrisBoard = new Board();
	
	public Board getTetrisBoard(){
		return tetrisBoard;
	}

}
