package Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;

import org.apache.commons.lang3.StringUtils;





public class ServerWorker extends Thread{
	Server server;
	Socket socket;
	OutputStream outputStream;
	InputStream inputStream;
	Connection dataConnection;
	public ServerWorker(Server server , Socket socket,Connection dataConnection) {	
		this.dataConnection = dataConnection;
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		//ObjectInputStream  objectInputStream = new ObjectInputStream(socket.getInputStream());
		//ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); 
		
		//String line = objectInputStream.readLine();
		String line;
		while((line=reader.readLine())!=null)
		{
			String[]token = StringUtils.split(line);
			System.out.println("reciverd "+token[0]);
			if(token[0].equals("chkID"))
			{
				// 
				System.out.println("Checking ID");
			}
		}
		
	}
}
