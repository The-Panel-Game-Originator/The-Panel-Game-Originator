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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CreateQuizPage {

	JLabel titleJLabel;
	JLabel uniqueIDJLabel;
	JLabel numberOfQuestionsJLabel;
	JLabel timeLimitPerQuestionJLabel;
	JPanel createQuizPageJPanel;
	JTextField uniqueIDField;
	JTextField numberOfQuestionsField;
	JTextField timeLimitPerQuestionField;
	JButton btn_backButton;
	JButton btn_next;
	JButton btn_checkUniqueID;
	public CreateQuizPage() {
		createQuizPageJPanel = new JPanel(new GridBagLayout());
		createQuizPageJPanel.setSize(Res.window_width,Res.window_height);
		createQuizPageJPanel.setBackground(Res.clr_bg_primary);
		uniqueIDJLabel=new JLabel("Enter a Unique ID");
		uniqueIDJLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		numberOfQuestionsJLabel = new JLabel("Number of Questions");
		numberOfQuestionsJLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		timeLimitPerQuestionJLabel = new JLabel("Time Limit(per ques.)");
		timeLimitPerQuestionJLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		uniqueIDField = new JTextField();
		numberOfQuestionsField = new JTextField();
		timeLimitPerQuestionField = new JTextField();
		btn_backButton=new JButton("<<Back");
		btn_next = new JButton("Next>>");
		btn_checkUniqueID = new JButton("Check");
		setup();
		// TODO Auto-generated constructor stub
	}
	private void setup()
	{
		GridBagConstraints g = new GridBagConstraints();
		g.gridx=0;
		g.gridy=0;
		uniqueIDJLabel.setForeground(Color.WHITE);
		createQuizPageJPanel.add(uniqueIDJLabel,g);
		g.gridx=1;
		uniqueIDField.setPreferredSize(new Dimension(200,40));
		createQuizPageJPanel.add(uniqueIDField,g);
		
		g.gridx=2;
		g.insets = new Insets(0, -100, 0, 0);
		btn_checkUniqueID.setPreferredSize(new Dimension(120,40));
		btn_checkUniqueID.setBackground(Res.clr_btn_violet);
		btn_checkUniqueID.setForeground(Color.WHITE);
		createQuizPageJPanel.add(btn_checkUniqueID,g);
		
		
		g = new GridBagConstraints();
		g.insets = new Insets(60, 0, 0, 0);
		g.gridx=0;
		g.gridy=1;
		timeLimitPerQuestionJLabel.setForeground(Color.WHITE);
		createQuizPageJPanel.add(timeLimitPerQuestionJLabel,g);
		g.gridx=1;
		timeLimitPerQuestionField.setPreferredSize(new Dimension(200,40));
		createQuizPageJPanel.add(timeLimitPerQuestionField,g);
		
		//g = new GridBagConstraints();
		g.gridx=0;
		g.gridy=2;
		numberOfQuestionsJLabel.setForeground(Color.WHITE);
		createQuizPageJPanel.add(numberOfQuestionsJLabel,g);
		g.gridx=1;
		numberOfQuestionsField.setPreferredSize(new Dimension(200,40));
		createQuizPageJPanel.add(numberOfQuestionsField,g);
		
		g= new GridBagConstraints();
		g.gridx = 0;
		g.gridy=3;
		g.insets = new Insets(120, -10, 0, 0);
		btn_backButton.setPreferredSize(new Dimension( 120,40));
		btn_backButton.setBackground(Res.clr_btn_green);
		createQuizPageJPanel.add(btn_backButton,g);
		g.gridx = 1;
		g.insets = new Insets(120, 400, 0, 0);
		btn_next.setBackground(Res.clr_btn_green);
		btn_next.setPreferredSize(new Dimension(120,40));
		createQuizPageJPanel.add(btn_next,g);
		
	}
	
	public JPanel getPanel()
	{
		return createQuizPageJPanel;
	}
	public static void main(String[]args)
	{
	 CreateQuizPage page = new CreateQuizPage();
	  JFrame frame = new JFrame();
	    frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(page.getPanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
