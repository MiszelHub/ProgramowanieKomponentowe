package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;

import model.BussinesMeeting;
import model.EventRepository;
import view.View;
/**
 *
 * This class is a handler for deleting events
 *
 */
public class DeleteEventAction implements ActionListener{
	SQLConnection sqlConnection;
	View view;
	/**
	 * constructor needs reference to {@link SQLConnection} and {@link View}
	 * @param sqlConnection
	 * @param view
	 */
	public DeleteEventAction(SQLConnection sqlConnection, View view) {
		super();
		this.sqlConnection = sqlConnection;
		this.view = view;
	}

	/**
	 * method responsible for event handling
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int eventId = view.getDeleteEventId();

		try {
			BussinesMeeting event = (BussinesMeeting) sqlConnection.SelectEventWithId(eventId);
		} catch (SQLException e1) {
			view.showMessage("Nie ma wydarzenia o takim ID");
		}

		sqlConnection.removeEventFromTableWithID(eventId, "bussinesmeetings");

//		view.getEventList().setText(sqlConnection.PrintEvents());
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		EventRepository repo = sqlConnection.filterEventsByDate(date.toString(), false);
		view.setEventList(repo.toString());
	}

}
