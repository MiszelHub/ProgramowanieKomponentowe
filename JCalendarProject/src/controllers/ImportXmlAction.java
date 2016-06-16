package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.EventBase;
import model.EventRepository;
import view.View;

class ImportXmlAction implements ActionListener{

	View view;
	SQLConnection sqlConnection;
	EventRepository repo;

	public ImportXmlAction(View view, SQLConnection sqlConnection, EventRepository repo) {
		super();
		this.sqlConnection = sqlConnection;
		this.repo = repo;
		this.view = view;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("przed====================================="); 
		ArrayList<EventBase> list = sqlConnection.getAllEvents().getEventList();
		for(EventBase ev : list){
			System.out.println(ev.toString());
		}
		XMLActions.loadEventsFromXML();
		
		list = repo.getEventList();
		System.out.println("po====================================");
		for(EventBase ev : list){
			sqlConnection.addEventToDatabaseTable("bussinesmeetings", ev.getTitle().toString(),
					ev.getDate().toString(),//+" "+ev.getHour()+":"+ev.getMinutes()+":00",
					ev.getLocation().toString(), ev.getDescription().toString(), null,null);
		}
		view.getEventList().setText(sqlConnection.PrintEvents());
		
	}
	
}
