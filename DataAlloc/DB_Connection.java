package DataAlloc;

import java.sql.Connection;
import java.sql.DriverManager;


public class DB_Connection {   // Save as "JdbcSelectTest.java"
	public static void main(String[] args) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		System.out.println(connection);
	}

	public Connection get_connection() {
		Connection connection = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AnimeUsers?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "myuser", "anime&Chill");
		}
		catch(Exception e) {
			System.out.println("hi");
			System.out.println(e);
		}
		return connection;
	}
}
