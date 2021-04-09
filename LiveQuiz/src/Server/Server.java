package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxExpr.ColumnIdentifier;

public class Server extends Thread{

	ServerSocket serverSocket;
	Connection conn;
	volatile Statement statement;
	ArrayList<ServerWorker> activeClient;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306";

	static final String USER = "project";
	static final String PASS = "1234"; 
	int port;
	public Server(int port) {
		this.port = port;
		activeClient = new ArrayList<ServerWorker>();
		conn = getConnection();
		getStatement();
		createDatabase();
		try {
			statement.execute("USE "+SqlQuery.DB_NAME);
			
		} catch (Exception e) {
			
			System.out.println("Database connected");
			e.printStackTrace();
		}
		createTable();
		
	}
public void run()
	{
		
		try {
			serverSocket = new ServerSocket(port);
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				ServerWorker worker = new ServerWorker(this,clientSocket,conn);
				worker.start();
				activeClient.add(worker);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

private Connection getConnection()
	{
	Connection conn; 
		try {
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 return conn;
			} 
		catch (Exception e) {
		
			System.out.println("Database connected");
			return null;
		}
	}
private void getStatement()
	{
	try {
		statement = conn.createStatement();
	} 
	catch (SQLException e) {
		
		e.printStackTrace();
		}
	}

private  void createDatabase()
	{
		try {
			statement.execute("CREATE DATABASE "+SqlQuery.DB_NAME);
		} catch (SQLException e) {
			System.out.println("Database already exist");
		}
	}
private void createTable()
	{
	try {
		statement.execute(SqlQuery.CREATE_TABLE_STRING);
		} 
	catch (SQLException e) {
		System.out.println("Table already exists");
		}
	}

}
