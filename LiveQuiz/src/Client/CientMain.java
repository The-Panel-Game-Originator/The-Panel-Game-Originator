package Client;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JOptionPane;



import NetworkUtils.Requests;

public class CientMain{

	

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		try {
			Socket socket = new Socket("localhost",80);
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			Requests requests = new Requests(outputStream,inputStream);
			frame = new JFrame();
			HomePage homePage = new HomePage(frame,requests);
			frame.setBackground(Res.clr_bg_primary);
			frame.setLayout(new BorderLayout());
			frame.setSize(Res.window_width,Res.window_height);
			frame.setResizable(false);
			frame.add(homePage.getHomePanel(),BorderLayout.CENTER);
			frame.setVisible(true);
		}
		 catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Server Is down", "Error", JOptionPane.OK_OPTION);
			System.exit(0);
		}
		
	}
}
