package model;

import java.util.ArrayList;

public class EventRepository {
	
	private ArrayList<EventBase> eventList;
	
	public EventRepository()
	{
		setEventList(new ArrayList<EventBase>());
		
	}

	public ArrayList<EventBase> getEventList() {
		return eventList;
	}

	public void setEventList(ArrayList<EventBase> eventList) {
		this.eventList = eventList;
	}
	
	public void addRecord(EventBase obj){
		eventList.add(obj);
	}
}
