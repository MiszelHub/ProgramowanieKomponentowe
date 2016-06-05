package controllers;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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

	public void addEventToDatabaseTable(String table,String id, String title, String date, String location, String description, String personImeetWith) 
	{
		connectToDataBase();
		String addQuerry = "INSERT INTO `events`.`"+table+"` (`id`, `title`, `date`, `location`, `description`, `personImeetwith`) VALUES (?,?,?,?,?,?);";
		java.sql.PreparedStatement statement=null;
		try {
			statement = dbConnection.prepareStatement(addQuerry);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		try {			
			statement.setString(1, id);
			statement.setString(2, title);
			statement.setString(3, date);
			statement.setString(4, location);
			statement.setString(5, description);
			statement.setString(6, personImeetWith);
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

}
