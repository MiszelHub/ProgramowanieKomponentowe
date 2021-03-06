package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.BussinesMeeting;
import model.EventRepository;
import view.UpdateEvent;
import view.View;
import exceptions.ColumnOutOfRangeException;
import exceptions.DateFormatException;
/**
* Event Handle for Editing events
*
*/
class EditEventAction implements ActionListener {

	UpdateEvent upEvent;
	View view;
	SQLConnection sqlConnection;
	int Id;

	/**
	 * Constructro with {@link View} and {@link SQLConnection} references
	 * @param view
	 * @param sqlConnection
	 */
	public EditEventAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}
	/**
	 * this method performs event handling using local classes
	 * which are implementations of {@link ActionListener}
	 */
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
				BussinesMeeting event;
				try {
					event = (BussinesMeeting) sqlConnection.SelectEventWithId(Id);

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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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

//				view.getEventList().setText(sqlConnection.PrintEvents());
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				EventRepository repo = sqlConnection.filterEventsByDate(date.toString(), false);
				view.setEventList(repo.toString());
				
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