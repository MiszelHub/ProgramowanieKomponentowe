package controllers;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controllers.SQLConnection.AlarmName;
import model.AlarmSound;
import view.View;
/**
 *Alarm Clock starts a timer that performs a task every minute
 *task is to check if there is an alarm set for event
 *
 */
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
				soundAlarm(connection.getNextAlarm());


			}
		};
		alarmTimer.schedule(task, 60000, 60000);
		if(timeBeforeAlarm <=0){
			sound.playAlarm();
			view.showAlarmMessage("LOLz");
			sound.stopAlarm();
		}



	}
	public void soundAlarm(AlarmName alarm){
		if(alarm.alarmt <0){
			connection.setAlarmToNull();
			sound.playAlarm();
			view.showAlarmMessage(alarm.namet);
			sound.stopAlarm();
		}
	}
}
