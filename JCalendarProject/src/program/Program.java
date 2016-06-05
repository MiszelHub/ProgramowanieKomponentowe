package program;


import java.sql.Time;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.ArrayList;

import controllers.XMLActions;

import view.View;

import model.Birthday;
import model.EventBase;
import model.EventRepository;
import model.SQLConnection;
public class Program {
	
	private static EventRepository repo = new EventRepository();
	
	public static void main(String[] args)  {
		View view = new View();
		SQLConnection c=null;
		
		
		
		
		try {
//			c = new SQLConnection("jdbc:mysql://127.0.0.1:3306/?user=Michal?autoReconnect=true&useSSL=false","Michal","kl4mk4123");
			c = new SQLConnection("jdbc:mysql://127.0.0.1:3306/?user=Konrad?autoReconnect=true&useSSL=false","Konrad","sYmbi0za0ms");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.connectToDataBase();
		//VALUES ('2', 'Meeteng1', '2016-06-21 00:50:00', 'Lodz', 'renting a car', 'JaN Kowalski');
		c.updateRecordInTable("bussinesmeetings", "2", "Meeteng2", "2016-06-21 00:50:01", "Lodz", "renting a car", "Jan Kowalski");
		
//		c.addEventToDatabaseTable("bussinesmeetings", "2", "Meeteng2", "2016-06-21 00:50:01", "Lodz", "renting a car", "Jan Kowalski");
		
		Birthday b = new Birthday("Title",new SimpleDateFormat("2011.11.11"),"13:00:01","11", "Lodz", "rent", "Jan kowalski",11);
		Birthday b1 = new Birthday("Title",new SimpleDateFormat("2011.11.11"),"13:00:02","12", "Lodzz", "rent", "Jan ZAmojski",11);
		Birthday b2 = new Birthday("Title",new SimpleDateFormat("2011.11.11"),"13:00:03","13", "Lodzzz", "rent", "Jan Jakistam",11);
		repo.addRecord(b);
		repo.addRecord(b1);
		repo.addRecord(b2);
		System.out.println("Original: " + repo.getEventList().toString());
		
		XMLActions.setEventRepo(repo);
		XMLActions.saveEventsToXML();
		System.out.println("After Save: " + repo.getEventList().toString());
		XMLActions.loadEventsFromXML();
		System.out.println("After Load: " + repo.getEventList().toString());
		
	
	}

}
