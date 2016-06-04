

import java.sql.Time;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.ArrayList;

import model.Birthday;
import model.EventBase;
import model.SQLConnection;
import model.ToXML;
public class Program {

	public static void main(String[] args)  {
		View.init();
		SQLConnection c=null;
		try {
			c = new SQLConnection("jdbc:mysql://127.0.0.1:3306/?user=Michal?autoReconnect=true&useSSL=false","Michal","kl4mk4123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.connectToDataBase();
		//VALUES ('2', 'Meeteng1', '2016-06-21 00:50:00', 'Lodz', 'renting a car', 'JaN Kowalski');
		c.updateRecordInTable("bussinesmeetings", "2", "Meeteng2", "2016-06-21 00:50:01", "Lodz", "renting a car", "Jan Kowalski");
		
		Birthday b = new Birthday("Title",new SimpleDateFormat("2011.11.11"),"13:00:01","11", "Lodz", "rent", "Jan kowalski",11);
		Birthday b1 = new Birthday("Title",new SimpleDateFormat("2011.11.11"),"13:00:01","11", "Lodz", "rent", "Jan ZAmojski",11);
		Birthday b2 = new Birthday("Title",new SimpleDateFormat("2011.11.11"),"13:00:01","11", "Lodz", "rent", "Jan Jakistam",11);
		ArrayList<EventBase> s = new ArrayList<EventBase>();
		s.add(b);
		s.add(b1);
		s.add(b2);
		
		ToXML.saveEventsToXML(s);
		
		ArrayList<EventBase> e = ToXML.loadEventsFromXML();
		System.out.println(e.size());
		
	
	}

}
