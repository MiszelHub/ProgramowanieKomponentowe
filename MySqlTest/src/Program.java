import java.sql.SQLException;

public class Program {

	public static void main(String [] args)
	{
		SQLConnection mysql=null;
		try {
			 mysql = new SQLConnection("jdbc:mysql://127.0.0.1:3306/?user=Michal?autoReconnect=true&useSSL=false","Michal","kl4mk4123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(mysql.toString());

		mysql.addRecordToDatabaseTable("names","Ktostam", "K",4);
		System.out.println("Dodajemy nowy rekord");
		System.out.println(mysql.toString());

		mysql.updateRecordInTable("names", "Zmieniony", "Ktos", 4);
		System.out.println("Zmieniamy Rekord");
		System.out.println(mysql.toString());

		mysql.removeRecordFromTableWithID(4, "names");
		System.out.println("Usuwamy Rekord");
		System.out.println(mysql.toString());

	}
}
