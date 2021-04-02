package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonReadableChannelException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinQuizPage {
	JPanel joinQuizJPanel;
	JLabel titleJLabel;
	JLabel nameJLabel;
	JTextField nameField;
	JLabel uniqueIDJLabel;
	JTextField uniqueIDField;
	JButton btn_joinButton;
	JButton btn_backButton;
	JFrame mainFrame;
	
	public JoinQuizPage(JFrame frame) {
		mainFrame = frame;
		joinQuizJPanel = new JPanel(new GridBagLayout());
		nameField = new JTextField();
		nameJLabel = new JLabel("Name: ");
		
		titleJLabel = new JLabel("LiveQuiz");
		uniqueIDField = new JTextField();
		uniqueIDJLabel = new JLabel("Test ID:");
		
		btn_joinButton = new JButton("JOIN");
		btn_backButton = new JButton("BACK");
		setup();	
	}
	
	private void setup()
	{
		joinQuizJPanel.setBackground(Res.clr_bg_primary);
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0 ;
		gridBagConstraints.gridy = 0 ;
		gridBagConstraints.gridwidth=2;
		//gridBagConstraints.anchor= GridBagConstraints.CENTER;
		gridBagConstraints.insets = new Insets(0,40,80,0);
		titleJLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,72));
		titleJLabel.setForeground(Res.clr_title_red);
		joinQuizJPanel.add(titleJLabel,gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(0,-10, 30, 0);
		nameJLabel.setFont(new Font("Sans Srief",Font.BOLD,20));
		nameJLabel.setForeground(Color.WHITE);
		joinQuizJPanel.add(nameJLabel,gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.insets = new Insets(0,20,30, 0);
		nameField.setPreferredSize(new Dimension(300,36));
		joinQuizJPanel.add(nameField,gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(0,0, 0, 0);
		uniqueIDJLabel.setFont(new Font("Sans Srief",Font.BOLD,20));
		uniqueIDJLabel.setForeground(Color.WHITE);
		joinQuizJPanel.add(uniqueIDJLabel,gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.insets = new Insets(0,20, 0, 0);
		uniqueIDField.setPreferredSize(new Dimension(300,36));
		joinQuizJPanel.add(uniqueIDField,gridBagConstraints);
		
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(40, 0, 0, 0);
		//gridBagConstraints.gridwidth=4;
		btn_joinButton.setBackground(Res.clr_btn_violet);
		btn_joinButton.setForeground(Color.WHITE);
		btn_joinButton.setPreferredSize(new Dimension(140,40));
		joinQuizJPanel.add(btn_joinButton,gridBagConstraints);
		
		gridBagConstraints.gridy = 4;
		gridBagConstraints.insets = new Insets(40, 0, 0, 0);
		//gridBagConstraints.gridwidth=4;
		btn_backButton.setBackground(Res.clr_title_red);
		btn_backButton.setForeground(Color.WHITE);
		btn_backButton.setPreferredSize(new Dimension(140,40));
		joinQuizJPanel.add(btn_backButton,gridBagConstraints);
		
		btn_backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomePage homePage = new HomePage(mainFrame);				
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().repaint();
				mainFrame.getContentPane().add(homePage.getHomePanel());
				mainFrame.getContentPane().validate();
				
			}
		});
	}
	public JPanel getPanel()
	{
		return joinQuizJPanel;
	}

}
