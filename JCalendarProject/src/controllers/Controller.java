package controllers;
import exceptions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.UpdatableResultSet;

import view.AddEvent;
import view.FilterEvents;
import view.UpdateEvent;
import view.View;
import model.AlarmSound;
import model.BussinesMeeting;
import model.EventBase;
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
		
		this.view.getMainMenu().setExportXmlBtn(new ExportXmlAction(view, sqlConnection));
		this.view.getMainMenu().setImportXmlBtn(new ImportXmlAction(view, sqlConnection, repo));

		this.view.addfilterEventsActionListener(new FilterEventsAction(view,sqlConnection));
		AlarmSound a = new AlarmSound("ohayou.wav");
		AlarmClock c = new AlarmClock(a,view,1000,sqlConnection);
		c.checkForAlarm();
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

	UpdateEvent upEvent;
	View view;
	SQLConnection sqlConnection;
	int Id;

	public EditEventAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}

	public void actionPerformed(ActionEvent arg0) {

		
		class UpdateEventAction implements ActionListener{
//
			SQLConnection sqlConnection;

			public UpdateEventAction(SQLConnection sqlConnection) {
				super();
				this.sqlConnection = sqlConnection;
			}

			public void chcekIfFieldsAreValid() throws ColumnOutOfRangeException
			{

				if(upEvent.getNameField().length() > 45 || upEvent.getLocalizationField().length() > 45 || upEvent.getDescriptionTxt().length() > 45)
					throw new ColumnOutOfRangeException();

			}
			public void checkDataFormat() throws DateFormatException
			{

				 if (upEvent.getDate() == null || !upEvent.getDate().matches("\\d{4}-\\d{2}-\\d{2}"))
						throw new DateFormatException();
			}
			
			public void actionPerformed(ActionEvent arg0) { 
				
				System.out.println(upEvent.getDate());
				
				try{
					chcekIfFieldsAreValid();
					checkDataFormat();
				}
				catch(ColumnOutOfRangeException e){
					view.showMessage(e.getMessage());
				}
				catch(DateFormatException e1){
					view.showMessage(e1.getMessage());
				}
				
				Id = upEvent.getChooseId().getValue();
				BussinesMeeting event = (BussinesMeeting) sqlConnection.SelectEventWithId(Id);
				try{
					upEvent.getNameFieldObject().setText(event.getTitle());
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date tmp = (Date)dateFormat.parseObject(event.getDate());
					System.out.println("alarm" + event.getAlarmDate());
					upEvent.getDateObject().setDate(tmp);
					
					upEvent.getLocalizationObject().setText(event.getLocation());
					
					upEvent.getDescriptionTxtObject().setText(event.getDescription());
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				

			}
		}
		
		class CommitUpdateAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				sqlConnection.updateRecordInTable("bussinesmeetings", Integer.toString(Id), upEvent.getNameField().toString(),
						upEvent.getDate().toString()+" "+upEvent.getHour()+":"+upEvent.getMinutes()+":00",
						upEvent.getLocalizationField().toString(), upEvent.getDescriptionTxt().toString(), null);
				
				String alarm = upEvent.getAlarmDate().toString()+" "+
						upEvent.getAlarmHour()+":"+upEvent.getAlarmMinutes()+":00";
				sqlConnection.addAllarmToDatabase(Id, alarm);
				
				view.getEventList().setText(sqlConnection.PrintEvents());
				upEvent.getFrame().dispose();
				
			}
			
		}

		class TurnOnTheAlarm implements ActionListener{


			@Override
			public void actionPerformed(ActionEvent e) {

				if(upEvent.getAlarmbox().isSelected()){
					upEvent.getAlarmDateChooser().setEnabled(true);
					upEvent.getAlarmHourBox().setEnabled(true);
					upEvent.getAlarmMinutesBox().setEnabled(true);
				}
				else{
					upEvent.getAlarmDateChooser().setEnabled(false);
					upEvent.getAlarmHourBox().setEnabled(false);
					upEvent.getAlarmMinutesBox().setEnabled(false);
				}
			}
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(view.getCalendar().getDate());
		upEvent = new UpdateEvent(cal);
		upEvent.getFrame().setTitle("Edytuj wydarzenie");
		upEvent.setFillEventDataBtn(new UpdateEventAction(sqlConnection));
		upEvent.AddAlarmAcionListener(new TurnOnTheAlarm());
		upEvent.addAddBtnListener(new CommitUpdateAction());


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

class ExportXmlAction implements ActionListener{
	View view;
	SQLConnection sqlConnection;

	public ExportXmlAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JFileChooser chooser = new JFileChooser();
//	    FileNameExtensionFilter filter = new FileNameExtensionFilter("xml","xml");
//	    chooser.setFileFilter(filter);
//	    int returnVal = chooser.showSaveDialog(view.getFrame());
//	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	    	if(!chooser.getSelectedFile().exists()){
//	    		
//	    		File fileToSave = chooser.getSelectedFile();
//	    		
//
//		    	try{
//		    		
//		    		BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));
//		    		ArrayList<EventBase> list = sqlConnection.getAllEvents().getEventList();
//		    		for(EventBase ev : list){
//		    			writer.write(ev.toString());
//		    			System.out.println(ev.toString());
//		    		}
//		    		fileToSave.createNewFile();
//		    		writer.close();
//		    		
//		    	}
//		    	catch(IOException ee){
//		    		ee.printStackTrace();
//		    	}
//	    	}
//	    	
//	    	
//	    	
//	       System.out.println("You chose to save this file: " +
//	            chooser.getSelectedFile().getAbsolutePath());
//	    }
		XMLActions.setEventRepo(sqlConnection.getAllEvents());
		XMLActions.saveEventsToXML();
		
	}
	
}

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



