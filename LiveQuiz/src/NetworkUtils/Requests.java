package NetworkUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import java.io.InputStreamReader;

public class Requests {

	volatile DataOutputStream dataOutputStream;
	volatile InputStream inputStream;
	public Requests(OutputStream outputStream,InputStream inputStream) {
		this.inputStream = inputStream;
		dataOutputStream = new DataOutputStream(outputStream);
				// TODO Auto-generated constructor stub
	}
	
	private void sender(String query)
	{
		try {
			dataOutputStream.writeUTF(query);
		} catch (IOException e) {
			System.out.println("Issue in sender method");
			e.printStackTrace();
		}
	}
	
	public void send_chkID(String ID)
	{
		sender("chkID "+ID);
	}
	public String getResonse() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String responseString = reader.readLine();
		return responseString;
	}
	
}
