package model;

import java.util.ArrayList;

import controllers.AlarmClock;

public class AlarmRepository {
	
	private ArrayList<AlarmClock> alarmclocks;
	
	public AlarmRepository() {
		alarmclocks = new ArrayList<AlarmClock>();
	}

	public ArrayList<AlarmClock> getAlarmclocks() {
		return alarmclocks;
	}

	public void setAlarmclocks(ArrayList<AlarmClock> alarmclocks) {
		this.alarmclocks = alarmclocks;
	}

	public void addRecord(AlarmClock obj){
		alarmclocks.add(obj);
	}

	public String toString()
	{
		StringBuilder stb = new StringBuilder();

		this.alarmclocks.forEach(alarmclock->stb.append(alarmclock.toString()+"\n"));

		return stb.toString();
	}
}
