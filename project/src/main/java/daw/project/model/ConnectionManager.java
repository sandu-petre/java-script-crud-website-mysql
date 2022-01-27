package daw.project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static Connection con;
	static String url;
	public static Connection getConnection() {
	try {
	String url = "jdbc:mysql://localhost:3307/daw";
	Class.forName("com.mysql.jdbc.Driver");
	try {
	con = DriverManager.getConnection(url, "root", "proiect2021");
	}
	catch (SQLException ex) {
	ex.printStackTrace();
	}
	} catch (ClassNotFoundException e) {
	System.out.println(e);
	}
	return con;
	}
}
