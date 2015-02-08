package tetris;


public class TimerControlInfo {
	
	private TimerControlInfo(){}
	
	private static class TetrisTimerInfoHolder {
		public static final TimerControlInfo INSTANCE = new TimerControlInfo();
	}
	
	public static TimerControlInfo getInstance(){
		return TetrisTimerInfoHolder.INSTANCE;
	}
	
	private TimerContorl tetrisTimer = new TimerContorl();
	
	public void timerStop(){
		tetrisTimer.timerStop();
	}

	public void timeStart() {
		tetrisTimer.timeStart();
	}
}
