package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import main.MainFrame;
import database.Connect;
import database.UserData;

public class UsersData extends JPanel {


	private static Connect c=new Connect();
	private JComboBox<String> comboBox;
	private String Username;
	private String[] DATA;
	/**
	 * Create the panel.
	 */
	public UsersData() {
		databaseVerify();
		makeGUI();
		this.setBackground(new Color(25,39,52));
	}
	private void databaseVerify()
	{
		try{
			Statement st=c.con.createStatement();
			String query="select count(username) from userdetails";
			java.sql.ResultSet rs=st.executeQuery(query);
			rs.next();
			int i=rs.getInt(1);
			DATA=new String[i];
			i=0;
			query="select username from userdetails";
			rs=st.executeQuery(query);
			while(rs.next())
				DATA[i++]=rs.getString("username");
			for(String s:DATA)
				System.out.println(s);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}
	public void makeGUI() {
		//public Verification(){
			setLayout(null);
			
			JButton btnSearch = new JButton("SEARCH");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Show details of that username
					new UserData(Username,true,"UsersData");
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("sans serif", Font.BOLD, 18));
			btnSearch.setBackground(new Color(98, 113, 202));
			btnSearch.setBounds(739, 223, 125, 36);
			add(btnSearch);
			
			
			
			JLabel lblUsersForVerification = new JLabel("Available Users");
			lblUsersForVerification.setForeground(Color.WHITE);
			lblUsersForVerification.setFont(new Font("sans serif", Font.BOLD, 18));
			lblUsersForVerification.setBounds(234, 223, 156, 28);
			add(lblUsersForVerification);
			
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(DATA));
			comboBox.setFont(new Font("Shruti", Font.BOLD, 16));
			comboBox.setBounds(434, 223, 266, 30);
			add(comboBox);
			Username=DATA[0];
			comboBox.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Username=(String)comboBox.getSelectedItem();				
				}
			});
			
			JButton btnNewButton = new JButton("BACK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainFrame.AddPanel(new MainAdmin());
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(219, 51, 13));
			btnNewButton.setFont(new Font("sans serif", Font.BOLD, 18));
			btnNewButton.setBounds(10, 512, 125, 36);
			add(btnNewButton);
			
			JLabel lblOnlineExamination = new JLabel("USERS");
			lblOnlineExamination.setForeground(Color.WHITE);
			//lblOnlineExamination.setBackground(Color.GREEN);
			lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
			lblOnlineExamination.setFont(new Font("sans serif", Font.BOLD, 50));
			lblOnlineExamination.setBounds(307, 28, 378, 82);
			add(lblOnlineExamination);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC34.PNG"));
			lblNewLabel.setBorder(new LineBorder(new Color(135, 206, 235), 4));
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setBounds(0, 0, 990, 558);
			add(lblNewLabel);
		}
}
