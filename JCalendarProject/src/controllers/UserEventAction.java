package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.ColumnOutOfRangeException;
import exceptions.DateFormatException;
import model.EventRepository;
import view.AddEvent;
import view.View;
/**
 * 
 * This Class is an event handler for {@link AddEvent} window
 *@see AddEvent
 */
class UserEventAction implements ActionListener {

	AddEvent addEvent;
	View view;
	SQLConnection sqlConnection;

	/**
	 * constructor requires a reference to view and sql connection
	 * @param view
	 * @param sqlConnection
	 */
	public UserEventAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}

	/**
	 * This method contains two local classes responsible which are implementation of action listener
	 * These two listeners are responsible for adding event and and alarm if user chooses to set one
	 */
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

//					view.getEventList().setText(sqlConnection.PrintEvents());
					java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					EventRepository repo = sqlConnection.filterEventsByDate(date.toString(), false);
					view.setEventList(repo.toString());
					
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