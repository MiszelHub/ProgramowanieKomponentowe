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
	private long timeBeforeAlarm;
	private View view;
	private SQLConnection connection;
	private AlarmSound sound;

	public AlarmClock(AlarmSound sound, View view, long timeBeforeAlarm, SQLConnection connection){
		alarmTimer = new Timer();
		this.view = view;
		this.timeBeforeAlarm = timeBeforeAlarm;
		this.connection = connection;
		this.sound = sound;
		
		
	}
	
	public void checkForAlarm(){
		task = new TimerTask() {
			
			@Override
			public void run() {
				timeBeforeAlarm = connection.getNextAlarm();
				sound.playAlarm();
				view.showAlarmMessage("LOLz");
				sound.stopAlarm();
				
			}
		};
		alarmTimer.schedule(task, 60000, 60000);
		if(timeBeforeAlarm <=0){
			sound.playAlarm();
			view.showAlarmMessage("LOLz");
			sound.stopAlarm();
		}
		
			
			
	}
}
