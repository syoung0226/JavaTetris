package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerControl implements ActionListener{

	private Timer timer;
//	private LineBlock block = new LineBlock();
	
	public TimerControl(){
		intialize();
	}
	
	private void intialize() {
		timer = new Timer(400, this);
	}

	public void timeStart() {
		timer.start();
	}
	public void timerStop(){
		timer.stop();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(timer.toString());
//		block.downMove();
	}

}
