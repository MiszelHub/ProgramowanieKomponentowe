package model;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.time.Duration;




public abstract class EventBase  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3101472232830792537L;

	protected String title;
	protected SimpleDateFormat date;
	protected String startTime;
	protected String duration;
	protected String location;
	protected String description;
	
	public EventBase(){}

	public EventBase(String title, SimpleDateFormat date, String startTime, String duration, String location,
			String description) {
		super();
		this.title = title;
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.location = location;
		this.description = description;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EventBase [title=" + title + ", date=" + date + ", startTime="
				+ startTime + ", duration=" + duration + ", location="
				+ location + ", description=" + description + "]";
	};
	
	
	
}

