package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import model.EventRepository;
import view.ArchivedEvents;

public class ArchivedEventsAction implements ActionListener{

	SQLConnection sqlConnection;
	java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

	public ArchivedEventsAction(SQLConnection sqlConnection) {
		super();
		this.sqlConnection = sqlConnection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArchivedEvents window = new ArchivedEvents();
		EventRepository repo = sqlConnection.filterEventsByDate(date.toString(), true);
//		System.out.println(sqlConnection.filterEventsByDate(date.toString(), true));
		XMLActions.setEventRepo(repo);
		window.getEventList().setText(XMLActions.getEventRepo().toString());
		
	}

}
