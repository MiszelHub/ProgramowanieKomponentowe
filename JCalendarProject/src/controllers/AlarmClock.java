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
	/**
	 *Constructor requires reference to AlarmSound class View and SQLConnection
	 *@param sound provides an audio stream
	 *@see AlarmSound
	 *@param view reference to a View Class
	 *@see View
	 *@param connection  reference to database connection
	 *@see SQLConnection
	 *
	 */
	public AlarmClock(AlarmSound sound, View view, SQLConnection connection){
		alarmTimer = new Timer();
		this.view = view;
		this.connection = connection;
		this.sound = sound;


	}
	/**
	 *method performs a TimerTask.It checks database for next allarm
	 *
	 */
	public void checkForAlarm(){
		task = new TimerTask() {

			@Override
			public void run() {
				soundAlarm(connection.getNextAlarm());


			}
		};
		alarmTimer.schedule(task, 60000, 60000);
	}
	/**
	 *Method starts and alarm using AlarmName class which hold a reference
	 *to name and alarm date
	 *@param alarm return alarm name and alarm date
	 *@see AlarmName
	 */
	public void soundAlarm(AlarmName alarm){
		if(alarm.alarmt <0){
			connection.setAlarmToNull();
			sound.playAlarm();
			view.showAlarmMessage(alarm.namet);
			sound.stopAlarm();
		}
	}
}
