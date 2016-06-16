package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import model.EventBase;
import model.EventRepository;
import view.View;
/**
 *
 * this class is responsible for xml import/export user actions
 *
 */
class ImportXmlAction implements ActionListener{

	View view;
	SQLConnection sqlConnection;
	/**
	 *constructor requires reference {@link View} {@link SQLConnection} and {@link EventRepository}
	 * @param view
	 * @param sqlConnection
	 * @param repo event repositorz
	 * @see view main window
	 * @see sqlConnection
	 * @see repo
	 */
	public ImportXmlAction(View view, SQLConnection sqlConnection) {
		super();
		this.sqlConnection = sqlConnection;
		this.view = view;
	}
		

	/**
	 * event handling for xml import/export
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("przed====================================="); 
		ArrayList<EventBase> list = sqlConnection.getAllEvents().getEventList();
//		for(EventBase ev : list){
//			System.out.println(ev.toString());
//		}
		XMLActions.loadEventsFromXML();
		
		list = XMLActions.getEventRepo().getEventList();
//		System.out.println("po====================================");
		for(EventBase ev : list){
			sqlConnection.addEventToDatabaseTable("bussinesmeetings", ev.getTitle().toString(),
					ev.getDate().toString(),//+" "+ev.getHour()+":"+ev.getMinutes()+":00",
					ev.getLocation().toString(), ev.getDescription().toString(), null,null);
		}
//		view.getEventList().setText(sqlConnection.PrintEvents());
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		EventRepository repo = sqlConnection.filterEventsByDate(date.toString(), false);
		view.setEventList(repo.toString());
		
//		list = sqlConnection.getAllEvents().getEventList();
//		for(EventBase ev : list){
//			System.out.println(ev.toString());
//		}
	}
	
}
