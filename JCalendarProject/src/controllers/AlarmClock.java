package controllers;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.AlarmSound;
import view.View;

public class AlarmClock {
	private Timer alarmTimer;
	private TimerTask task;
	private int hours;
	private int minutes;
	private View view;
	
	public AlarmClock(AlarmSound sound, View view){
		alarmTimer = new Timer();
		this.view = view;
		task = new TimerTask() {
			
			@Override
			public void run() {
				sound.playAlarm();
				view.showAlarmMessage("eventName");
				sound.stopAlarm();
			}
		};
		alarmTimer.schedule(task, 1000);
	}
}
