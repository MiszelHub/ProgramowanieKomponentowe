package controllers;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import model.EventBase;
import model.EventRepository;
import program.*;
import view.MainMenu;
/**
* this class provides us with with functionality of a top level static class
* It lets us (de)serialize an object to xml file
*
*/
public final class XMLActions {
	private static XMLEncoder encoder;
	private static XMLDecoder decoder;

	private static MainMenu menu;
	private static EventRepository eventRepo;

	public static EventRepository getEventRepo() {
		return eventRepo;
	}

	public static void setEventRepo(EventRepository eventRepo) {
		XMLActions.eventRepo = eventRepo;
	}

	/**
	 * constructor is private so this class works like a top level static class
	 */
	private XMLActions(){};
	/**
	 * this method is responsible for saving events from the event repo to the xml file
	 */
	public static void saveEventsToXML()
	{
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Events.xml")));
			encoder.writeObject(eventRepo.getEventList());
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is responsible for importing events form xml file
	 */
	public static void loadEventsFromXML()
	{
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Events.xml")));
			 eventRepo.setEventList((ArrayList<EventBase>) decoder.readObject());
			 decoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
