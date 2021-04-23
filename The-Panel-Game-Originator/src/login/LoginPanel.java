package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import admin.AdminPanel;
import user.UserLogin;
import main.MainFrame;
import main.Panel1;

public class LoginPanel extends JPanel {
	private JButton btnUser;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		this.setBackground(new Color(25,39,52));
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Panel1());
			}
		});
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
			}
		});
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBackground(new Color(98, 113, 202));
		btnAdmin.setFont(new Font("sans serif", Font.BOLD, 30));
		btnAdmin.setBounds(256, 322, 478, 99);
		add(btnAdmin);
		
		btnUser = new JButton("USER");
		btnUser.setFocusable(false);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserLogin());
			}
		});
		btnUser.setForeground(Color.WHITE);
		btnUser.setBackground(new Color(4, 252, 96));
		btnUser.setFont(new Font("sans serif", Font.BOLD, 30));
		btnUser.setBounds(256, 212, 478, 99);
		add(btnUser);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(219, 51, 13));
		btnNewButton.setFont(new Font("sans serif", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("LOGIN");
		lblOnlineExamination.setForeground(Color.WHITE);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("sans serif", Font.BOLD, 41));
		lblOnlineExamination.setBounds(388, 46, 214, 105);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC33.PNG"));
		lblNewLabel.setBorder(new LineBorder(new Color(64, 224, 208), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);

	}

}
