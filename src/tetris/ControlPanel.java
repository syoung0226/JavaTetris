package tetris;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener{
	//TODO Key로 제어하는것 추가하기

	private Button startBtn = new Button("start");
	private Button endBtn = new Button("end");

	public ControlPanel() {
		super();
		initialize();
	}

	private void initialize() {
		startBtn.addActionListener(this);
		endBtn.addActionListener(this);
		add(startBtn);
		add(endBtn);
		setBackground(Color.lightGray);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			System.out.println("start");
			TimerControlInfo.getInstance().timeStart();
		} else if (e.getSource() == endBtn) {
			System.out.println("end");
			TimerControlInfo.getInstance().timerStop();
		}
	}
}
