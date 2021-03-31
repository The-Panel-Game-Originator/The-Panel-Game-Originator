package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import sun.font.FileFontStrike;
import sun.net.www.content.text.plain;

public class SingleQuestionItem {
	
	private int QuestionNumber;
	private JPanel singleQuestionPanel;
	private JLabel questionNumberJLabel;
	private JTextArea questionTextArea;
	private JTextField option_w1;
	private JTextField option_w2;
	private JTextField option_w3;
	private JTextField option_c;
	private JLabel optionTag[];
	private JPanel questionTypePanel;
	private JPanel optionPanel;
	
	
	public SingleQuestionItem(int QuestionNumber) {
		this.QuestionNumber = QuestionNumber;
		singleQuestionPanel = new JPanel(new GridBagLayout());
		singleQuestionPanel.setBounds(0, 0, Res.window_width,Res.window_height);
		questionNumberJLabel = new JLabel("Question No: "+Integer.toString(QuestionNumber));
		questionTextArea = new JTextArea(Res.question_text_Area_height,Res.question_text_Area_widht);
		questionTypePanel = new JPanel(new GridBagLayout());
		
		optionTag = new JLabel[4];
		optionTag[0] = new JLabel("Correct Option: ");
		optionTag[0].setForeground(Color.WHITE);
		optionTag[1] = new JLabel("Second Option: "); 
		optionTag[1].setForeground(Color.WHITE);
		optionTag[2] = new JLabel("Third  Option: "); 
		optionTag[2].setForeground(Color.WHITE);
		optionTag[3] = new JLabel("Fourth Option: "); 
		optionTag[3].setForeground(Color.WHITE);
		
		option_w1 = new JTextField();
		option_w1.setPreferredSize(new Dimension(Res.option_Panel_weidth,Res.option_Panel_height));
		
		option_w2 = new JTextField();
		option_w2.setPreferredSize(new Dimension(Res.option_Panel_weidth,Res.option_Panel_height));
		
		option_w3 = new JTextField();
		option_w3.setPreferredSize(new Dimension(Res.option_Panel_weidth,Res.option_Panel_height));
		
		option_c  = new JTextField();
		option_c.setPreferredSize(new Dimension(Res.option_Panel_weidth,Res.option_Panel_height));
		
		optionPanel = new JPanel(new GridBagLayout());
		optionPanel.setBackground(Res.clr_bg_primary);
		
		setup();
		
	}
	private void setup()
	{
		
		singleQuestionPanel.setBackground(Res.clr_bg_primary);
		GridBagConstraints g = new GridBagConstraints();
		
		//Setting Up Question Number
		g.gridx=0;
		g.gridy=0;
		g.insets = new Insets(0, 0, 0, 740);
		questionNumberJLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		questionNumberJLabel.setForeground(Color.WHITE);
		singleQuestionPanel.add(questionNumberJLabel,g);
		
		//Setting up Question Text Area
		g.insets = new Insets(0,0,0,0);
		g.gridy=1;
		questionTextArea.setLineWrap(true);
		questionTextArea.setWrapStyleWord(true);
		questionTextArea.setMargin(new Insets(10,10,10,10));
		questionTextArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
		singleQuestionPanel.add(questionTextArea,g);
		
		g.gridy=2;
		g.insets = new Insets(10, -760, 0, 0);
		singleQuestionPanel.add(questionTypePanel,g);
		singleQuestionPanel.setBackground(Res.clr_bg_primary);
		
		g= new GridBagConstraints();
		
		g.gridx=0;
		g.gridy=0;
		g.insets= new Insets(0, -85, 0, 0);
		optionPanel.add(optionTag[0],g);
		g.gridy=1;
		g.insets= new Insets(0, 0, 0, 0);	
		optionPanel.add(option_c,g);
		
		g.gridy=2;
		g.insets= new Insets(0, -85, 0, 0);
		optionPanel.add(optionTag[1],g);
		g.gridy=3;
		g.insets= new Insets(0, 0, 0, 0);
		optionPanel.add(option_w1,g);
		
		g.gridy=4;
		g.insets= new Insets(0, -85, 0, 0);
		optionPanel.add(optionTag[2],g);
		g.gridy=5;
		g.insets= new Insets(0, 0, 0, 0);
		optionPanel.add(option_w2,g);
		
		g.gridy=6;
		g.insets= new Insets(0, -90, 0, 0);
		optionPanel.add(optionTag[3],g);
		g.gridy=7;
		g.insets= new Insets(0, 0, 0, 0);
		optionPanel.add(option_w3,g);
		
		g.gridx=0;
		g.gridy=3;
		g.insets= new Insets(0, 0, 0, 0);	
		g.insets = new Insets(10, -720, 0, 0);
		singleQuestionPanel.add(optionPanel,g);
		
	}
	
	public JPanel getSingleQuestionPanel(){
		return singleQuestionPanel;
	}
	
	public String getQuestion(){
		return questionTextArea.getText().toString();
	}
	
	public String getCorretOption(){
	 return option_c.getText().toString();	
	}
	
	public String getOption_w1(){
		return option_w1.getText().toString();
		
	}
	
	public String getOption_w2(){
		return option_w2.getText().toString();
	}
	
	public String getOption_w3() {
		return option_w3.getText().toString();
	}
	
	// Main method for Testing 
	public static void main(String[]args)
	{
		SingleQuestionItem p = new SingleQuestionItem(1);
	
		JFrame frame = new JFrame();
		frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(p.getSingleQuestionPanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
