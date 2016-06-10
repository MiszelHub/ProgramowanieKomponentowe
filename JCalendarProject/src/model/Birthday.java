package model;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Birthday extends EventBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String whoseBirhday;
	private int howOld;
	public Birthday() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Birthday(String title, String date, String location,
			String description,String whoseBirthday, int howOld) {
		super(title, date, location, description);
		this.whoseBirhday = whoseBirthday;
		this.howOld = howOld;
	}
	
	public String getWhoseBirhday() {
		return whoseBirhday;
	}
	public void setWhoseBirhday(String whoseBirhday) {
		this.whoseBirhday = whoseBirhday;
	}
	public int getHowOld() {
		return howOld;
	}
	public void setHowOld(int howOld) {
		this.howOld = howOld;
	}
	@Override
	public String toString() {
		return "Birthday [whoseBirhday=" + whoseBirhday + ", howOld=" + howOld
				+ ", title=" + title + ", date=" + date + ", startTime="
				+ ", location="
				+ location + ", description=" + description + "]";
	}
	
	
	
	

}
