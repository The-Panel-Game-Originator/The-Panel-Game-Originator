package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuizWaitPage {

	JPanel quizWaitPanel;
	JLabel waitMessageJLabel;
	Icon loadingIcon;
	JLabel loadingLabel;
	public QuizWaitPage() {
		quizWaitPanel = new JPanel(new GridBagLayout());
		quizWaitPanel.setBackground(new Color(14, 30, 47));
		waitMessageJLabel = new JLabel("Waiting for the host to start the Quiz..!");
		loadingIcon = new ImageIcon(this.getClass().getResource("loading.gif"));
		loadingLabel = new JLabel(loadingIcon);
		setup();
	}
	
	private void setup()
	{
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight=2;
		waitMessageJLabel.setFont(new Font("Sans Serief",Font.BOLD,20));
		waitMessageJLabel.setForeground(Color.WHITE);
		quizWaitPanel.add(waitMessageJLabel,gridBagConstraints);
		
		gridBagConstraints.gridy=1;
		quizWaitPanel.add(loadingLabel,gridBagConstraints);
		
	}


	public JPanel getPanel()
	{
		return quizWaitPanel;
	}
	
	public static void main(String[]args)
	{
		QuizWaitPage p = new QuizWaitPage();
		JFrame frame = new JFrame();
		frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(p.getPanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
}
