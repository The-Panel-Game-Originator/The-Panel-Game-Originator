package database;

import java.sql.*;

import javax.swing.JOptionPane;
import java.sql.Statement;


public class Connect {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306";
	static final String USER = "project";
	static final String PASS = "1234"; 
	volatile Statement statement;
	public Connection con;
	public Connect() {
		
		try{
			con=DriverManager.getConnection(DB_URL,USER,PASS);
			statement = con.createStatement();
			statement.execute("USE "+"project02");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			System.out.println("Connection Established.");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver is not Loaded.");
			System.out.println("Exception : "+e.getMessage());
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Can't connect to server.");
			System.out.println("Connection is not established : "+e.getMessage()+"\n\n"+e);
		}
		
	}
	public static void main(String []args)
	{
		new Connect();
	}

}
