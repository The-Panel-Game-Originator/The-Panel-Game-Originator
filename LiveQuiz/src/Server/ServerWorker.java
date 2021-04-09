package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;





public class ServerWorker extends Thread{
	Server server;
	Socket socket;
	OutputStream outputStream;
	InputStream inputStream;
	DataOutputStream dataOutputStream;
	volatile Connection databaseConnection;
	
	public ServerWorker(Server server , Socket socket,Connection databaseConnection) {	
		this.databaseConnection = databaseConnection;
		this.server = server;
		this.socket = socket;
	}
	public void run()
	{
		try {
			handleClient();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleClient() throws Exception
	{
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		dataOutputStream = new DataOutputStream(outputStream);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		//ObjectInputStream  objectInputStream = new ObjectInputStream(socket.getInputStream());
		//ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); 
		
		//String line = objectInputStream.readLine();
		String line;
		while((line=reader.readLine())!=null)
		{
			String[]token = StringUtils.split(line);
			//System.out.println("recived :"+token[0]);
			if(token[0].equals("chkID"))
			{
				// 
				//System.out.println("Checking ID: "+token[1]);
				if(checkID(token[1]))
				{
					dataOutputStream.writeUTF("!OK\n");
				}
				else
				{
					dataOutputStream.writeUTF("OK\n");
				}
			}
		}
		
	}
	
	private boolean checkID(String ID)
	{
		try {
			PreparedStatement statement = databaseConnection.prepareCall(SqlQuery.CHECKID_STRING);
			statement.setString(1, ID);
			 ResultSet resultset = statement.executeQuery();
			 if(resultset != null)
			 {
				 if(resultset.getRow()>0) return true;
				 else return false;
			 }
			 else return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return true;
		}
	}
}
