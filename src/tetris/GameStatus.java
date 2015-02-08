package tetris;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameStatus extends JLabel{
	
	private int detroyedLineNumber;

	public GameStatus(){
		super();
		initialize();
	}
	private void initialize(){
		detroyedLineNumber = 0;
		setText(String.valueOf(detroyedLineNumber));
	}
	
	public int getDetroyedLineNumber() {
		return detroyedLineNumber;
	}
	public void setDetroyedLineNumber(int detroyedLineNumber) {
		this.detroyedLineNumber = detroyedLineNumber;
	}	
}
