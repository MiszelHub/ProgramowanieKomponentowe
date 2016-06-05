package model;

import java.util.ArrayList;

import com.sun.media.jfxmediaimpl.MediaDisposer.Disposable;

public class EventRepository implements Disposable{
	
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

	@Override
	public void dispose() {
		ToXML.saveEventsToXML(this.eventList);
		
	}
}
