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

	private XMLActions(){};
	
	public static void saveEventsToXML(EventRepository eventRepo)
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
	public static void loadEventsFromXML(EventRepository eventRepo)
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
