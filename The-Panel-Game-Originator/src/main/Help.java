package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends JPanel {

	/**
	 * Create the panel.
	 */
	public Help() {
		setFocusable(false);
		setEnabled(false);
		setLayout(null);
		this.setBackground(new Color(25,39,52));
		JTextArea txtrAboutHelpLine = new JTextArea();
		txtrAboutHelpLine.setEditable(false);
		txtrAboutHelpLine.setForeground(Color.BLACK);
		txtrAboutHelpLine.setBackground(Color.LIGHT_GRAY);
		txtrAboutHelpLine.setLineWrap(true);
		txtrAboutHelpLine.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		txtrAboutHelpLine.setRows(30);
		txtrAboutHelpLine.setText("HELLO!!!\r\n\r\nThis is an PANEL GAME ORIGINATOR in which admin can conduct  an online examination of users .Users have to registered himself/herself first than they must be verified by admin after that he/she can give the examination.\r\nThis project consists of many swing components like JPanel,Jframe,etc.\r\n\n\n\n\n\r\nProject Made by :\r\n\n Vishal, Puranjay, Somya, Rajeswar\r\n\r\r\n");
		txtrAboutHelpLine.setBounds(177, 91, 637, 342);
		add(txtrAboutHelpLine);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(250, 78, 491, 2);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Panel Game Originator");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1.setBounds(280, 24, 450, 47);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Panel1());
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(219, 51, 13));
		btnNewButton.setFont(new Font("sans serif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC7.PNG"));
		lblNewLabel.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}
}
