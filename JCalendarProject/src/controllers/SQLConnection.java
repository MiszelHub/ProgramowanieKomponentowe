package controllers;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import model.BussinesMeeting;
import model.EventBase;
import model.EventRepository;
/**
* this class is responsible for conencting to database as well as
* providing methods for extracting and inserting data to Database
*
*/
public class SQLConnection {

	private java.sql.Connection dbConnection;
	private String jdbcConnectionString;
	private String user;
	private String password;
	/**
	 * Constructor takes parameters responsible for user credential information
	 * necessary to connect to database server
	 *
	 * @param jdbcConnectionString connection string for database server
	 * @param user User name
	 * @param password User password
	 * @throws ClassNotFoundException
	 */
	public SQLConnection(String jdbcConnectionString, String user, String password) throws ClassNotFoundException{

		Class.forName("com.mysql.jdbc.Driver");
		this.jdbcConnectionString = jdbcConnectionString;
		this.user = user;
		this.password = password;

	}
	/**
	 * This Method Performs a connection to database it has to be invoked
	 * before attempting to query database
	 */
	public void connectToDataBase()
	{
		try {
			dbConnection = DriverManager.getConnection(jdbcConnectionString, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public java.sql.Connection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}
	/**
	 * This method is responsible for adding a new record to event database
	 *
	 * @param table name of the database table
	 * @param title title of the event
	 * @param date date of the event
	 * @param location
	 * @param description
	 * @param personImeetWith
	 * @param alarm date of the alarm
	 */
	public void addEventToDatabaseTable(String table, String title, String date, String location, String description, String personImeetWith, String alarm)
	{
		connectToDataBase();
		String addQuerry = "INSERT INTO `events`.`"+table+"` (`title`, `date`, `location`, `description`, `personImeetwith`,`alarm`) VALUES (?,?,?,?,?,?);";
		java.sql.PreparedStatement statement=null;
		try {
			statement = dbConnection.prepareStatement(addQuerry);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			statement.setString(1, title);
			statement.setString(2, date);
			statement.setString(3, location);
			statement.setString(4, description);
			statement.setString(5, personImeetWith);
			statement.setString(6, alarm);
			statement.addBatch();
			statement.executeBatch();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * this mehtod is used to remove record for the database
	 * @param id event id in database
	 * @param table name of a table in database
	 */
	public void removeEventFromTableWithID(int id, String table)
	{
		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement("DELETE FROM `events`.`"+table+"` WHERE `id`='"+id+"';");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used for updating  existing event in database
	 *
	 * @param table name of the table in databse
	 * @param id  event id in database
	 * @param title
	 * @param date
	 * @param location
	 * @param description
	 * @param personImeetWith
	 */
	public void updateRecordInTable(String table,String id, String title, String date, String location, String description, String personImeetWith)
	{
		connectToDataBase();
		String sqlUpdate = "UPDATE `events`.`"+table+"` SET `title`=?, `date`=?, `location`=?, `description`=?, `personImeetwith`=? WHERE `id`=?;";

		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement(sqlUpdate);

			statement.setString(1, title);
			statement.setString(2, date);
			statement.setString(3, location);
			statement.setString(4, description);
			statement.setString(5, personImeetWith);
			statement.setString(6, id);
			statement.addBatch();
			statement.executeUpdate();
			statement.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this mathod is responsible for adding alarm to data base event record
	 *
	 * @param id event id
	 * @param datetime date of the alarm
	 */
	public void addAllarmToDatabase(int id, String datetime)
	{
		//VALUES ('1', 'FuckYou', '2016-06-05 00:00:00', '1');";
		connectToDataBase();
		//String sqlQuerry = "INSERT INTO `events`.`alarm` (`idAlarm`, `alarmMessage`, `alarmDate`, `evend_id`) VALUES (?, ?, ?, ?);";
		String sqlUpdate = "UPDATE `events`.`bussinesmeetings` SET `alarm`= ? WHERE `id`="+id+";";
		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement(sqlUpdate);
			statement.setString(1, datetime);
			statement.addBatch();
			statement.executeUpdate();
			statement.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This method performs a select query and returns the event with matching id
	 *
	 * @param id event id
	 * @return EventBase
	 * @see EventBase
	 */
	public EventBase SelectEventWithId(int id)
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, date, location, description, personImeetwith FROM events.bussinesmeetings where bussinesmeetings.id = "+id+";";
		Statement statement=null;
		ResultSet rs= null;
		BussinesMeeting event= new BussinesMeeting();

		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return event;
	}

	/**
	 * This Method return all existing events form the database
	 * @return EventRepository
	 * @see EventRepository
	 */
	public EventRepository getAllEvents()
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, date, location, description, personImeetwith, alarm FROM events.bussinesmeetings;";
		Statement statement=null;
		ResultSet rs= null;
		EventRepository repo = new EventRepository();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));
			event.setAlarmDate(rs.getString("alarm"));

			repo.addRecord(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repo;

	}
	/**
	 * This method return string representation of events in database
	 * @return String
	 */
	public String PrintEvents()
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, date, location, description, personImeetwith, alarm FROM events.bussinesmeetings;";
		Statement statement=null;
		ResultSet rs= null;
		StringBuilder stb = new StringBuilder();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));
			event.setAlarmDate(rs.getString("alarm"));

			stb.append(event.toString()+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stb.toString();

	}
	/**
	 * This method filters events in database by date
	 * @param date
	 * @return String
	 */
	public String filterEventsByYear(String date)
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, bussinesmeetings.date, location, description, personImeetwith FROM events.bussinesmeetings WHERE Date(bussinesmeetings.date) >= '"+date+"'";
		Statement statement=null;
		ResultSet rs= null;
		StringBuilder stb = new StringBuilder();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));

			stb.append(event.toString()+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stb.toString();

	}
	/**
	 * This method filters events in database by date
	 * @param date
	 * @return EventRepository
	 * @see EventRepository
	 */
	public EventRepository filterEventsByDate(String date)
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, bussinesmeetings.date, location, description, personImeetwith FROM events.bussinesmeetings WHERE Date(bussinesmeetings.date) >= '"+date+"'";
		Statement statement=null;
		ResultSet rs= null;
		EventRepository tmp = new EventRepository();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));

			tmp.addRecord(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tmp;

	}
	/**
	 * This method filters events in database by Location
	 * @param location
	 * @return String
	 */
	public String filtereventsByLocation(String location)
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, bussinesmeetings.date, location, description, personImeetwith FROM events.bussinesmeetings WHERE location = '"+location+"'";
		Statement statement=null;
		ResultSet rs= null;
		StringBuilder stb = new StringBuilder();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));

			stb.append(event.toString()+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stb.toString();
	}

	/**
	 * This method filters events in database by date and location
	 * @param location
	 * @param date date of the event
	 * @return String
	 */
	public String filtereventsByLocationAndDate(String location, String date)
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, bussinesmeetings.date, location, description, personImeetwith FROM events.bussinesmeetings WHERE location >= '"+
							location+"' AND Date(bussinesmeetings.date) >= '"+date+"'";
		Statement statement=null;
		ResultSet rs= null;
		StringBuilder stb = new StringBuilder();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));

			stb.append(event.toString()+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stb.toString();
	}
	/**
	 * this inner class holds necessary information about alarm - name and date
	 * @author user
	 *
	 */
	public class AlarmName{
		public long alarmt;
		public String namet;
		public AlarmName(){
//			alarmt=a;
//			namet = n;
		}
	}
	/**
	 * this Method queries database for the next alarm and returns Alarm name and date
	 * @return {@link AlarmName}
	 * @see AlarmName
	 */
	public AlarmName getNextAlarm(){
		connectToDataBase();
		String sqlQuerry = "SELECT alarm-NOW() as timeremaining, title FROM events.bussinesmeetings WHERE alarm is not null order by alarm ASC LIMIT 1";
		Statement statement=null;
		ResultSet rs= null;

		AlarmName alarm= new AlarmName();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

				alarm.alarmt = rs.getLong("timeremaining");
				alarm.namet = rs.getString("title");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alarm;
	}
	/**
	 * this method is used to set alarm date to null so it won't ring more then once
	 */
	public void setAlarmToNull(){
		//UPDATE `events`.`bussinesmeetings` SET `alarm`=NULL WHERE `id`='2';
		connectToDataBase();
		String sqlUpdate = "UPDATE `events`.`bussinesmeetings` SET `alarm`=NULL WHERE alarm is not null order by alarm ASC LIMIT 1;";
		java.sql.PreparedStatement statement=null;
		try {

			//statement = dbConnection.prepareStatement("DELETE FROM `events`.`bussinesmeetings` WHERE alarm is not null order by alarm ASC LIMIT 1");
			statement = dbConnection.prepareStatement(sqlUpdate);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeUpdate();
			this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
