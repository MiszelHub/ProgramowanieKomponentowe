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
	public BussinesMeeting(String title, SimpleDateFormat date, String startTime, String duration, String location,
			String description, String nameOfThePersonYouSetUpMeetingWith) {
		super(title, date, startTime, duration, location, description);
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
		return "BussinesMeeting [nameOfThePersonYouSetUpMeetingWith="
				+ nameOfThePersonYouSetUpMeetingWith + ", title=" + title
				+ ", date=" + date + ", startTime=" + startTime + ", duration="
				+ duration + ", location=" + location + ", description="
				+ description + "]";
	}
	
	

}
