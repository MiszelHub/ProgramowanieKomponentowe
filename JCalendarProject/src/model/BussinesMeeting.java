package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class BussinesMeeting extends EventBase{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nameOfThePersonYouSetUpMeetingWith;

	public BussinesMeeting() {
		super();

	}
	public BussinesMeeting(int id,String title, String date,  String location,
			String description, String nameOfThePersonYouSetUpMeetingWith, String alarmDate) {
		super(id,title, date, location, description,alarmDate);
		this.setNameOfThePersonYouSetUpMeetingWith(nameOfThePersonYouSetUpMeetingWith);
	}
	public String getNameOfThePersonYouSetUpMeetingWith() {
		return nameOfThePersonYouSetUpMeetingWith;
	}
	public void setNameOfThePersonYouSetUpMeetingWith(String nameOfThePersonYouSetUpMeetingWith) {
		this.nameOfThePersonYouSetUpMeetingWith = nameOfThePersonYouSetUpMeetingWith;
	}
	@Override
	public String toString() {

		return super.toString();
//		return super.toString() +" Person I meet= "+ this.nameOfThePersonYouSetUpMeetingWith+" ]";
	}



}
