package tetris;


public class TimerInfo {
	
	private TimerInfo(){}
	
	private static class TetrisTimerInfoHolder {
		public static final TimerInfo INSTANCE = new TimerInfo();
	}
	
	public static TimerInfo getInstance(){
		return TetrisTimerInfoHolder.INSTANCE;
	}
	
	private TTimer tetrisTimer = new TTimer();
	
	public void timerStop(){
		tetrisTimer.timerStop();
	}

	public void timeStart() {
		tetrisTimer.timeStart();
	}
}
