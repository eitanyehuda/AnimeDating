package DataAlloc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataManipulate {
	public static void main(String[] args) {
		DataManipulate obj_DataManipulate = new DataManipulate();
		String user = "Chris";
		String ID = "1";
		String eps = "100";
		String score = "10";
		obj_DataManipulate.add_data(user, ID, eps, score);
		obj_DataManipulate.show_data();
	}
	
	public void show_data() {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps = null;
		try {
			String query = "select * from users";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Users - " + rs.getString("username"));
			}
			connection.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean check_data(String name) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		
		PreparedStatement ps = null;
		try {
			String query = "select * from users";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String entry = rs.getString("username");
				if (name == entry) {
					connection.close();
					return true;
				}
				
			}
			connection.close();
			return false;
		}
		
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	public void add_data(String username, String animeID, String episodes, String score) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		boolean is_used = check_data(username);
		if (is_used)
			return;
		String values = "Values('" + username + "', '" + animeID + "', '" + episodes + "', '" + score + "')";
		
		
		PreparedStatement ps = null;
		try {
			String command = "insert into users(username, animeID, episodes, score)";
			String statement = command + values;
			ps = connection.prepareStatement(statement);
			ps.execute();
			connection.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
