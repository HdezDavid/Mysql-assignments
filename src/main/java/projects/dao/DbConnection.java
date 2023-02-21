package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static int PORT = 3306;
	private static String SCHEMA = "projects"; 
	private static String USER = "projects";
	
	
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", HOST, PORT, SCHEMA, USER, PASSWORD);
		System.out.println("Attempt to connect");
		
		try {
			Connection connect = DriverManager.getConnection(uri);
			System.out.println("Connecting to schema " + SCHEMA + " is a success");
			return connect;
		} catch (SQLException e) {
			System.out.println("CAN NOT CONNECT");
			throw new DbException(e);
		}
	}
	
	

}
