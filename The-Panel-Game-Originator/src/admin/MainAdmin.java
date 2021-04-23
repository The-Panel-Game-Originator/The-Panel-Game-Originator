package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.UIManager;
import course.CoursePanel;
import database.Connect;

public class MainAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private boolean executeQuery(String query)
	{
		Connect c=new Connect();
		try{
			Statement st=c.con.createStatement();
			if(st.executeQuery(query).next())
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}
	public MainAdmin() {
		setLayout(null);
		this.setBackground(new Color(25,39,52));
		JButton btnUsers = new JButton("USERS");
		btnUsers.setFocusable(false);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from userdetails"))
					MainFrame.AddPanel(new UsersData());
				else
					JOptionPane.showMessageDialog(null, "No users found.");
			}
		});
		
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFocusable(false);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel.password=JOptionPane.showInputDialog(null, "New password");
			}
		});
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setBackground(new Color(98, 113, 202));
		btnChangePassword.setBounds(824, 103, 158, 30);
		add(btnChangePassword);
		btnUsers.setForeground(Color.WHITE);
		btnUsers.setFont(new Font("sans serif", Font.BOLD, 18));
		btnUsers.setBackground(new Color(2, 107, 227));
		btnUsers.setBounds(330, 429, 332, 79);
		add(btnUsers);
		
		JButton btnResults = new JButton("COURSE RESULTS");
		btnResults.setFocusable(false);
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from result"))
					MainFrame.AddPanel(new CoursesResult());
				else
					JOptionPane.showMessageDialog(null, "No result found.");
			}
		});
		btnResults.setForeground(Color.WHITE);
		btnResults.setFont(new Font("sans serif", Font.BOLD, 18));
		btnResults.setBackground(new Color(2, 107, 227));
		btnResults.setBounds(330, 159, 332, 79);
		add(btnResults);
		
		JButton btnVerification = new JButton("VERIFICATION");
		btnVerification.setFocusable(false);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(executeQuery("select *from userdetails where verify=0"))
					new Verification();
				else
					JOptionPane.showMessageDialog(null, "No users for verification.");
			}
		});
		btnVerification.setForeground(Color.WHITE);
		btnVerification.setFont(new Font("sans serif", Font.BOLD, 18));
		btnVerification.setBackground(new Color(2, 107, 227));
		btnVerification.setBounds(330, 249, 332, 79);
		add(btnVerification);
		
		JButton btnManageCourses = new JButton("MANAGE COURSES");
		btnManageCourses.setFocusable(false);
		btnManageCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new CoursePanel());
			}
		});
		btnManageCourses.setForeground(Color.WHITE);
		btnManageCourses.setFont(new Font("sans serif", Font.BOLD, 18));
		btnManageCourses.setBackground(new Color(2, 107, 227));
		btnManageCourses.setBounds(330, 339, 332, 79);
		add(btnManageCourses);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
				JOptionPane.showMessageDialog(null, "Successfully Logout.");	
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(219, 51, 1));
		btnNewButton.setFont(new Font("sans serif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 11, 125, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("ADMIN MENU");
		lblOnlineExamination.setForeground(Color.WHITE);
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("sans serif", Font.BOLD, 41));
		lblOnlineExamination.setBounds(194, 28, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC34.PNG"));
		lblNewLabel.setBorder(new LineBorder(new Color(135, 206, 235), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}
}
