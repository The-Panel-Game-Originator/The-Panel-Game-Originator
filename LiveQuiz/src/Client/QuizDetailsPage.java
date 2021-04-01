package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuizDetailsPage {

	JPanel quizeDetailsJPanel;
	JLabel uniqueId;
	JLabel numberOfJoinedPeople;
	JButton btn_startQuizButton;
	QuizDetailsPage(String uniqueIDstr,int numberofPeople)
	{
		quizeDetailsJPanel = new JPanel(new GridBagLayout());
		uniqueId = new JLabel("Unique ID: "+uniqueIDstr);
		numberOfJoinedPeople = new JLabel("Participants: "+numberofPeople);
		btn_startQuizButton = new JButton("Start");
		setup();
	}
	private void setup()
	{
		quizeDetailsJPanel.setBackground(Res.clr_bg_primary);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=0;
		gridBagConstraints.gridy=0;
		gridBagConstraints.insets= new Insets(-600, -700, 0, 0);
		uniqueId.setFont(new Font("Sans Serif",Font.BOLD,24));
		uniqueId.setForeground(Color.MAGENTA);
		quizeDetailsJPanel.add(uniqueId,gridBagConstraints);
		
		gridBagConstraints.gridy=1;
		gridBagConstraints.insets= new Insets(-580, -690, 0, 0);
		numberOfJoinedPeople.setFont(new Font("Sans Serif",Font.BOLD,24));
		numberOfJoinedPeople.setForeground(Color.MAGENTA);
		quizeDetailsJPanel.add(numberOfJoinedPeople,gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=0;
		gridBagConstraints.gridy=0;
		btn_startQuizButton.setPreferredSize(new Dimension(180,60));
		btn_startQuizButton.setBackground(Res.clr_btn_green);
		btn_startQuizButton.setForeground(Color.WHITE);
		btn_startQuizButton.setFont(new Font("Sans Sherif",Font.BOLD,16));
		quizeDetailsJPanel.add(btn_startQuizButton,gridBagConstraints);
	}
	
	public JPanel getPanel()
	{
		return quizeDetailsJPanel;
	}
	
	public static void main(String[]args)
	{
	 QuizDetailsPage page = new QuizDetailsPage("1230",100);
	  JFrame frame = new JFrame();
	    frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(page.getPanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
