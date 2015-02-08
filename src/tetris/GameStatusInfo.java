package tetris;


public class GameStatusInfo {
	//TODO 추후 삭제
	public static final GameStatusInfo instance = new GameStatusInfo();
	private GameStatusInfo(){	}
	
	public static GameStatusInfo getinstance(){
		return instance;
	}
	
	private GameStatus tetrisStatusBar = new GameStatus();
	
	public GameStatus getTetrisStatusBar(){
		return tetrisStatusBar;
	}
}
