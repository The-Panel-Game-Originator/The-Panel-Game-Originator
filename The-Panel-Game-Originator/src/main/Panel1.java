package main;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import login.LoginPanel;

public class Panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel1() {
		setLayout(null);
		this.setBackground(new Color(25,39,52));
		JButton btnNext = new JButton("NEXT");
		btnNext.setFocusable(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new LoginPanel());
			}
		});
		btnNext.setForeground(new Color(253, 245, 230));
		btnNext.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNext.setBackground(new Color(4, 252, 96));
		btnNext.setBounds(892, 511, 89, 36);
		add(btnNext);
		
		JButton btnNewButton = new JButton("HELP");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new Help());
			}
		});
		btnNewButton.setForeground(new Color(253, 245, 230));
		btnNewButton.setBackground(new Color(98, 113, 202));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("PanelGame");
		lblOnlineExamination.setForeground(new Color(219, 51, 13));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("sans serif", Font.BOLD, 80));
		lblOnlineExamination.setBounds(198, 130, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblSystem = new JLabel("ORIGINATOR");
		lblSystem.setForeground(new Color(219, 51, 13));
		lblSystem.setBackground(new Color(220, 20, 60));
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setFont(new Font("sans serif", Font.BOLD, 80));
		lblSystem.setBounds(198, 270, 603, 105);
		add(lblSystem);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC10.PNG"));
		lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}
}
