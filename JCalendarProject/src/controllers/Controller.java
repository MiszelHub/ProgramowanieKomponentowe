package controllers;
import exceptions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import view.AddEvent;
import view.FilterEvents;
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
		this.view.addEditEventActionListener(new EditEventAction(view, sqlConnection));

		XMLActions.setEventRepo(this.repo);
		this.view.getEventList().setText(sqlConnection.PrintEvents());

		this.view.addfilterEventsActionListener(new FilterEventsAction(view,sqlConnection));
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
////		return "Lista Event�w\n\n\n\nfjsgiejgio";
//	}
//
//	public static void addEvent(){
//		addEventToDatabaseTable
//	}


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

			public void chcekIfFieldsAreValid() throws ColumnOutOfRangeException
			{

				if(addEvent.getNameField().length() > 45 || addEvent.getLocalizationField().length() > 45 || addEvent.getDescriptionTxt().length() > 45)
					throw new ColumnOutOfRangeException();

			}
			public void checkDataFormat() throws DateFormatException
			{

				 if (addEvent.getDate() == null || !addEvent.getDate().matches("\\d{4}-\\d{2}-\\d{2}"))
						throw new DateFormatException();
			}
			public void actionPerformed(ActionEvent arg0) {

				try{
					chcekIfFieldsAreValid();
					checkDataFormat();
					if(!addEvent.getAlarmbox().isSelected())
					{
					sqlConnection.addEventToDatabaseTable("bussinesmeetings", addEvent.getNameField().toString(),
							addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00",
							addEvent.getLocalizationField().toString(), addEvent.getDescriptionTxt().toString(), null,null);
					}else{
						sqlConnection.addEventToDatabaseTable("bussinesmeetings", addEvent.getNameField().toString(),
								addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00",
								addEvent.getLocalizationField().toString(), addEvent.getDescriptionTxt().toString(), null,addEvent.getAlarmDate().toString()+" "+
								addEvent.getAlarmHour()+":"+addEvent.getAlarmMinutes()+":00");
					}

					System.out.println(("bussinesmeetings" + addEvent.getNameField().toString() +
							addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00" +
							addEvent.getLocalizationField().toString() + addEvent.getDescriptionTxt().toString()));

					view.getEventList().setText(sqlConnection.PrintEvents());
					addEvent.getFrame().dispose();
				}catch(ColumnOutOfRangeException e){

					view.showMessage(e.getMessage());

				}catch(DateFormatException e1){
					view.showMessage(e1.getMessage());
				}

			}
		}

		class TurnOnTheAlarm implements ActionListener{


			@Override
			public void actionPerformed(ActionEvent e) {

			if(addEvent.getAlarmbox().isSelected()){
				addEvent.getAlarmDateChooser().setEnabled(true);
				addEvent.getAlarmHourBox().setEnabled(true);
				addEvent.getAlarmMinutesBox().setEnabled(true);
			}else{
				addEvent.getAlarmDateChooser().setEnabled(false);
				addEvent.getAlarmHourBox().setEnabled(false);
				addEvent.getAlarmMinutesBox().setEnabled(false);
			}
			}
		}




		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(view.getCalendar().getDate());
		addEvent = new AddEvent(cal);
		addEvent.AddAlarmAcionListener(new TurnOnTheAlarm());
		addEvent.addAddBtnListener(new AddEventAction(sqlConnection));


	}

}

class EditEventAction implements ActionListener {

	AddEvent addEvent;
	View view;
	SQLConnection sqlConnection;

	public EditEventAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}

	public void actionPerformed(ActionEvent arg0) {


//		class AddEventAction implements ActionListener{
//
//			SQLConnection sqlConnection;
//
//			public AddEventAction(SQLConnection sqlConnection) {
//				super();
//				this.sqlConnection = sqlConnection;
//			}
//
//			public void chcekIfFieldsAreValid() throws ColumnOutOfRangeException
//			{
//
//				if(addEvent.getNameField().length() > 45 || addEvent.getLocalizationField().length() > 45 || addEvent.getDescriptionTxt().length() > 45)
//					throw new ColumnOutOfRangeException();
//
//			}
//			public void checkDataFormat() throws DateFormatException
//			{
//
//				 if (addEvent.getDate() == null || !addEvent.getDate().matches("\\d{4}-\\d{2}-\\d{2}"))
//						throw new DateFormatException();
//			}
//			public void actionPerformed(ActionEvent arg0) {
//
//				try{
//					chcekIfFieldsAreValid();
//					checkDataFormat();
//					sqlConnection.addEventToDatabaseTable("bussinesmeetings", addEvent.getNameField().toString(),
//							addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00",
//							addEvent.getLocalizationField().toString(), addEvent.getDescriptionTxt().toString(), null);
//
//					System.out.println(("bussinesmeetings" + addEvent.getNameField().toString() +
//							addEvent.getDate().toString()+" "+addEvent.getHour()+":"+addEvent.getMinutes()+":00" +
//							addEvent.getLocalizationField().toString() + addEvent.getDescriptionTxt().toString()));
//
//					view.getEventList().setText(sqlConnection.PrintEvents());
//					addEvent.getFrame().dispose();
//				}catch(ColumnOutOfRangeException e){
//
//					view.showMessage(e.getMessage());
//
//				}catch(DateFormatException e1){
//					view.showMessage(e1.getMessage());
//				}
//			}
//		}

//		class TurnOnTheAlarm implements ActionListener{
//
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			if(addEvent.getAlarmbox().isSelected()){
//				addEvent.getAlarmDate().setEnabled(true);
//				addEvent.getAlarmHour().setEnabled(true);
//				addEvent.getAlarmMinutes().setEnabled(true);
//			}else{
//				addEvent.getAlarmDate().setEnabled(false);
//				addEvent.getAlarmHour().setEnabled(false);
//				addEvent.getAlarmMinutes().setEnabled(false);
//			}
//			}
//		}




		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(view.getCalendar().getDate());
		addEvent = new AddEvent(cal);
		addEvent.getFrame().setTitle("Edytuj wydarzenie");
//		addEvent.AddAlarmAcionListener(new TurnOnTheAlarm());
//		addEvent.addAddBtnListener(new AddEventAction(sqlConnection));


	}

}

class FilterEventsAction implements ActionListener{
	View view;
	FilterEvents filterEvents;
	SQLConnection sqlconnection;

	public FilterEventsAction(View view, SQLConnection sqlconnection) {
		super();
		this.view = view;
		this.sqlconnection = sqlconnection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		filterEvents = new FilterEvents(new GregorianCalendar());

		class FilterButtonClicked implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(filterEvents.getDateChooser().isEnabled() && !filterEvents.getLocalization().isEnabled())
				//view.getEventList().setText(sqlconnection.filterEventsByYear(filterEvents.getDate()));
				view.getEventList().setText(sqlconnection.filterEventsByDate(filterEvents.getDate()).toString());
				
				else if((!filterEvents.getDateChooser().isEnabled()) && filterEvents.getLocalization().isEnabled())
					view.getEventList().setText(sqlconnection.filtereventsByLocation(filterEvents.getLocalizationContents()));
					
				
				else if(filterEvents.getDateChooser().isEnabled() && filterEvents.getLocalization().isEnabled())
						view.getEventList().setText(sqlconnection.filtereventsByLocationAndDate(filterEvents.getLocalizationContents(), filterEvents.getDate()));
			}
			

		}

		this.filterEvents.addFilterButtonListener(new FilterButtonClicked());

	}



}



