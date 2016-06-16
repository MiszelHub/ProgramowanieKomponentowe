package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.BussinesMeeting;
import view.View;

public class DeleteEventAction implements ActionListener{
	SQLConnection sqlConnection;
	View view;

	public DeleteEventAction(SQLConnection sqlConnection, View view) {
		super();
		this.sqlConnection = sqlConnection;
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int eventId = view.getDeleteEventId();
		
		try {
			BussinesMeeting event = (BussinesMeeting) sqlConnection.SelectEventWithId(eventId);
		} catch (SQLException e1) {
			view.showMessage("Nie ma wydarzenia o takim ID");
		}

		sqlConnection.removeEventFromTableWithID(eventId, "bussinesmeetings");
			
		view.getEventList().setText(sqlConnection.PrintEvents());
	}

}
