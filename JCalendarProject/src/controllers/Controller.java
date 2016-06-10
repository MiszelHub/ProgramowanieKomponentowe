package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import view.AddEvent;
import view.View;
import model.EventRepository;

public class Controller {

	EventRepository repo;
	View view;
	AddEvent addEventView = null;
	SQLConnection sqlConnection;

	
	public Controller(EventRepository repo, View view, SQLConnection sqlConnection) {
		super();
		this.repo = repo;
		this.view = view;
		this.sqlConnection = sqlConnection;
		UserEventAction usrEvtAction = new UserEventAction(view, sqlConnection);
		this.view.addUserEventActionListener(usrEvtAction);
		
		XMLActions.setEventRepo(this.repo);
		this.view.getEventList().setText(sqlConnection.PrintEvents());
	}

	public EventRepository getRepo() {
		return repo;
	}

	public void setRepo(EventRepository repo) {
		this.repo = repo;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public AddEvent getAddEventView() {
		return addEventView;
	}

	public void setAddEventView(AddEvent addEventView) {
		this.addEventView = addEventView;
	}

	public SQLConnection getSqlConnection() {
		return sqlConnection;
	}

	public void setSqlConnection(SQLConnection sqlConnection) {
		this.sqlConnection = sqlConnection;

	}

}

class UserEventAction implements ActionListener {

	AddEvent addEvent;
	View view;
	SQLConnection sqlConnection;

	public UserEventAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		
		class AddEventAction implements ActionListener{

			SQLConnection sqlConnection;

			public AddEventAction(SQLConnection sqlConnection) {
				super();
				this.sqlConnection = sqlConnection;
			}
			
			public void actionPerformed(ActionEvent arg0) {
				
				sqlConnection.addEventToDatabaseTable("bussinesmeetings", addEvent.getNameField().toString(), 
						addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00", 
						addEvent.getLocalizationField().toString(), addEvent.getDescriptionTxt().toString(), null);
				
				System.out.println(("bussinesmeetings" + addEvent.getNameField().toString() +
						addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00" +
						addEvent.getLocalizationField().toString() + addEvent.getDescriptionTxt().toString()));
				
				view.getEventList().setText(sqlConnection.PrintEvents());
				addEvent.getFrame().dispose();
				
			}
			
		}
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(view.getCalendar().getDate());		
		addEvent = new AddEvent(cal);
		
		addEvent.addAddBtnListener(new AddEventAction(sqlConnection));
		
	}

}



