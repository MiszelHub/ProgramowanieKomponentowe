import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SQLConnection {

	private java.sql.Connection dbConnection;

//	public SQLConnection() throws ClassNotFoundException, SQLException {
//
//		Class.forName("com.mysql.jdbc.Driver");
//		dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=Michal?autoReconnect=true&useSSL=false","Michal","kl4mk4123");
//	}
	public SQLConnection(String jdbcConnectionString, String user, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection(jdbcConnectionString, user, password);
	}

	public java.sql.Connection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public String toString()
	{

			java.sql.PreparedStatement statement=null;
			StringBuilder result = new StringBuilder();

			try {
				statement = dbConnection.prepareStatement("SELECT * FROM testdb.names");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet results=null;
			try {
				 results = statement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(results.next())
				{
					result.append(results.getString(1)+" "+results.getString(2)+"\n");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result.toString();

	}
	public void addRecordToDatabaseTable(String table,String firstName, String lastName, int id)
	{
		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement("INSERT INTO `testdb`.`"+table+"` (`first`, `last`, `id`) VALUES ('"+firstName+"', '"+lastName+"', '"+id+"');");

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
	public void removeRecordFromTableWithID(int id, String table)
	{
		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement("DELETE FROM `testdb`.`"+table+"` WHERE `id`='"+id+"';");

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
	public void updateRecordInTable(String table, String firstName, String lastName, int id)
	{
		java.sql.PreparedStatement statement=null;
		try {

			statement = dbConnection.prepareStatement("UPDATE `testdb`.`"+table+"` SET `first`='"+firstName+"', `last`='"+lastName+"' WHERE `id`='"+id+"';");

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
	
}
