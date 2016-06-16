package model;

import java.util.ArrayList;

/**
* Repository class helps us with saving data to XML
*
*
*/
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
	/**
	 * method for adding new events to local repository
	 * @param obj
	 */
	public void addRecord(EventBase obj){
		eventList.add(obj);
	}
	/**
	 * method filters repository by location
	 * @deprecated we found not much usage for it yet
	 * @param location
	 * @return
	 */
	public String filterByLocation(String location){
		StringBuilder stb = new StringBuilder();
		for(EventBase event : eventList)
		{
			if(event.getLocation() == location)
				stb.append(event.toString());
		}
		return stb.toString();
	}

	public String toString()
	{
		StringBuilder stb = new StringBuilder();

		this.eventList.forEach(event->stb.append(event.toString()+"\n"));

		return stb.toString();
	}

}
