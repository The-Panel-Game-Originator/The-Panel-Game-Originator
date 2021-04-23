package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class FrogotPassword extends JPanel implements FocusListener{
	private JTextField txtUsername;
	JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	public FrogotPassword() {

		setLayout(null);
		this.setBackground(new Color(25,39,52));
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserLogin());
			}
		});
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(217, 423, 557, 62);
		add(lblNewLabel_1);
		
		JButton btnGetYourPassword = new JButton("SUBMIT");
		btnGetYourPassword.setFont(new Font("sans serif", Font.BOLD, 12));
		btnGetYourPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtUsername.getForeground()!=SystemColor.controlShadow)
				{
					String Pass=UserLogin.exixtsUsername(txtUsername.getText());
					if(Pass!=null)
					{
						lblNewLabel_1.setText("Your Password : "+Pass);
						System.out.println("Password : "+Pass);
					}
					else
					{
						lblNewLabel_1.setText("You are not registered user.");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Enter username");
				}
			}
		});
		btnGetYourPassword.setForeground(Color.WHITE);
		btnGetYourPassword.setBackground(new Color(98, 113, 202));
		btnGetYourPassword.setBounds(413, 270, 164, 36);
		add(btnGetYourPassword);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(SystemColor.controlShadow);
		txtUsername.setText("USERNAME");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setBounds(347, 206, 297, 36);
		add(txtUsername);
		txtUsername.addFocusListener(this);
			
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(219, 51, 13));
		btnNewButton.setFont(new Font("sans serif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("FORGOT PASSWORD");
		lblOnlineExamination.setForeground(Color.WHITE);
		//lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("sans serif", Font.BOLD, 41));
		lblOnlineExamination.setBounds(194, 22, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC15.PNG"));
		lblNewLabel.setBorder(new LineBorder(Color.LIGHT_GRAY, 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}
	public void focusGained(FocusEvent arg0) {
		if(arg0.getSource()==txtUsername && txtUsername.getForeground()==SystemColor.controlShadow)
		{
			txtUsername.setText("");
			txtUsername.setForeground(Color.black);
			txtUsername.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		}
		
	}
	public void focusLost(FocusEvent arg0) {
		if(txtUsername.getText().equals(""))
		{
			txtUsername.setForeground(SystemColor.controlShadow);
			txtUsername.setText("USERNAME");
			txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));	
		}
	}
}