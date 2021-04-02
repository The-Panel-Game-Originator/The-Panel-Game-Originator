package Client;

import java.awt.BorderLayout;


import javax.swing.JFrame;

public class CientMain {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		HomePage homePage = new HomePage(frame);
		frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(homePage.getHomePanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
