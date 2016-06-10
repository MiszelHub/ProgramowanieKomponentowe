package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import view.AddEvent;
import view.View;
import model.EventRepository;

public final class Controller {

	EventRepository repo;
	View view;
	AddEvent addEventView = null;
	SQLConnection sqlConnection;

	
	public Controller(EventRepository repo, View view, SQLConnection sqlConnection) {
		super();
		this.repo = repo;
		this.view = view;
		this.sqlConnection = sqlConnection;
		UserEventAction usrEvtAction = new UserEventAction();
		this.addEventView = usrEvtAction.getAddEvent();
		this.view.addUserEventActionListener(usrEvtAction);
		try{
			this.addEventView.addAddBtnListener(new AddEventAction(sqlConnection, addEventView));
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
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

	
//	public void printEventList(){
//		view.setEventList(repo.getEventList().toString());
////		return "Lista Eventów\n\n\n\nfjsgiejgio";
//	}
//	
//	public static void addEvent(){
//		addEventToDatabaseTable
//	}
	

}

class UserEventAction implements ActionListener {

	AddEvent addEvent = null;
	
	public void actionPerformed(ActionEvent arg0) {
		AddEvent addEvent = new AddEvent(new GregorianCalendar());
		this.addEvent = addEvent;
	}

	public AddEvent getAddEvent() {
		return addEvent;
	}

	public void setAddEvent(AddEvent addEvent) {
		this.addEvent = addEvent;
	}
	
}

class AddEventAction implements ActionListener{

	SQLConnection sqlConnection;
	AddEvent addEvent;

	public AddEventAction(SQLConnection sqlConnection, AddEvent addEvent) {
		super();
		this.sqlConnection = sqlConnection;
		this.addEvent = addEvent;
	}
	
	public void actionPerformed(ActionEvent arg0) {
//		System.out.println(nameField.getText()+" "+localizationField.getText()+" "+
//		descriptionTxt.getText()+" "+date.getDate().toString()+" "+
//		hour.getValue()+":"+minutes.getValue());

		sqlConnection.addEventToDatabaseTable("bussinesmeetings", addEvent.getNameField().toString(), addEvent.getDate().toString(), 
				addEvent.getLocalizationField().toString(), addEvent.getDescriptionTxt().toString(), null);
		System.out.println(("bussinesmeetings" + addEvent.getNameField().toString() + addEvent.getDate().toString() + 
				addEvent.getLocalizationField().toString() + addEvent.getDescriptionTxt().toString()));
		
	}
}
