package model;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.time.Duration;




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

	public EventBase(){}

	public EventBase(int id,String title, String date, String location,
			String description) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.location = location;
		this.description = description;

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
		return this.getClass().getSimpleName()+"[id="+id+" title=" + title + ", date=" + date + ", startTime="
				+", location=" + location + ", description=" + description+",";
	};



}

