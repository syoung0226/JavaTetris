package tetris;


public class TStatusBarInfo {
	public static final TStatusBarInfo instance = new TStatusBarInfo();
	
	private TStatusBarInfo(){	}
	
	public static TStatusBarInfo getinstance(){
		return instance;
	}
	
	private TStatusBar tetrisStatusBar = new TStatusBar();
	
	public TStatusBar getTetrisStatusBar(){
		return tetrisStatusBar;
	}
}
