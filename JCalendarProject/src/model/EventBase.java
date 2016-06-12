package model;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.time.Duration;



/**
* Base Event Class is a super class we use for aur events
*
*/
public abstract class EventBase  implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -3101472232830792537L;

	protected int id;
	protected String title;
	protected String date;
	protected String location;
	protected String description;
	protected String alarmDate;

	public EventBase(){}

	public EventBase(int id,String title, String date, String location,
			String description, String alarmDate) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.location = location;
		this.description = description;
		this.alarmDate = alarmDate;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
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
		String alarm = this.alarmDate;
		if(alarm == null) alarm="brak";
		return "id="+id+" Nazwa: " + title + ", Data: " + date + ", Alarm: "+
				alarm+", Miejsce: " + location + ", Opis: " + description+"\n"+
				"---------------------------------------------------------------------------------------------------------";
	}

	public String getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(String alarmDate) {
		this.alarmDate = alarmDate;
	};



}

