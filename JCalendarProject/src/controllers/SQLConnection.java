package controllers;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import model.BussinesMeeting;
import model.EventBase;
import model.EventRepository;

public class SQLConnection {

	private java.sql.Connection dbConnection;
	private String jdbcConnectionString;
	private String user;
	private String password;
	public SQLConnection(String jdbcConnectionString, String user, String password) throws ClassNotFoundException{

		Class.forName("com.mysql.jdbc.Driver");
		this.jdbcConnectionString = jdbcConnectionString;
		this.user = user;
		this.password = password;

	}

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

	public void addEventToDatabaseTable(String table, String title, String date, String location, String description, String personImeetWith)
	{
		connectToDataBase();
		String addQuerry = "INSERT INTO `events`.`"+table+"` (`title`, `date`, `location`, `description`, `personImeetwith`) VALUES (?,?,?,?,?);";
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
	public void addAllarmToDatabase(int id, String message, String datetime, int eventIDd)
	{
		//VALUES ('1', 'FuckYou', '2016-06-05 00:00:00', '1');";
		connectToDataBase();
		String sqlQuerry = "INSERT INTO `events`.`alarm` (`idAlarm`, `alarmMessage`, `alarmDate`, `evend_id`) VALUES (?, ?, ?, ?);";
		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement(sqlQuerry);

			statement.setInt(1, id);
			statement.setString(2, message);
			statement.setString(3, datetime);
			statement.setInt(4, eventIDd);
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

	public void getAllEvents(EventRepository repo)
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, date, location, description, personImeetwith FROM events.bussinesmeetings;";
		Statement statement=null;
		ResultSet rs= null;

		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
			event.setDate(rs.getString("date"));
			event.setDescription(rs.getString("description"));
			event.setLocation(rs.getString("location"));
			event.setTitle(rs.getString("title"));
			event.setNameOfThePersonYouSetUpMeetingWith(rs.getString("personImeetwith"));

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


	}
	public String PrintEvents()
	{
		connectToDataBase();
		String sqlQuerry = "SELECT id, title, date, location, description, personImeetwith FROM events.bussinesmeetings;";
		Statement statement=null;
		ResultSet rs= null;
		StringBuilder stb = new StringBuilder();
		try {
			statement = dbConnection.createStatement();
			rs = statement.executeQuery(sqlQuerry);
			while(rs.next()){

			BussinesMeeting event= new BussinesMeeting();
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

}
