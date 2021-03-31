package Client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HomePage {
	private JPanel homePanel;
	private JLabel title;
	private JLabel tagLine;
	private JButton btn_CreateQuiz;
	private JButton btn_JoinQuiz;
	private JPanel buttonPanel;
	HomePage()
	{
		// Initializing the GUI components 
		homePanel = new JPanel(new GridBagLayout());
		homePanel.setBounds(0,0,Res.window_height,Res.window_width);
		title = new JLabel("LiveQuiz");
		tagLine=new JLabel("Test your knowledge here");
		btn_CreateQuiz = new JButton("CREATE QUIZ");
		btn_JoinQuiz = new JButton("JOIN QUIZ");
		
		//Styling the Buttons
		//Removing Borders
		btn_CreateQuiz.setBorder(BorderFactory.createEmptyBorder());
		btn_JoinQuiz.setBorder(BorderFactory.createEmptyBorder());
		
		//Setting up the Dimensions of the buttons
		btn_CreateQuiz.setPreferredSize(new Dimension(120,40));
		btn_JoinQuiz.setPreferredSize(new Dimension(120,40));
		
		//Setting up the Background Color
		btn_CreateQuiz.setBackground(Res.clr_btn_green);
		btn_JoinQuiz.setBackground(Res.clr_btn_violet);
		
		//Setting up the Button text Color
		btn_CreateQuiz.setForeground(Color.WHITE);
		btn_JoinQuiz.setForeground(Color.WHITE);
		
		homePanelSetup();
	}
	
	private void homePanelSetup()
	{
		//Setting up the panel background and layouts.
		homePanel.setBackground(Res.clr_bg_primary);
		GridBagConstraints g = new GridBagConstraints();
		GridBagConstraints g_for_btns = new GridBagConstraints();
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setBackground(Res.clr_bg_primary);
		
		//Adding the Title
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,88));
		title.setForeground(Res.clr_title_red);
		g.gridx=0;
		g.gridy=0;
		homePanel.add(title,g);
		
		//Adding the Tagline
		g.insets = new Insets(-16,184,0,0);
		tagLine.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		tagLine.setForeground(Color.WHITE);
		g.gridx=0;
		g.gridy=1;
		homePanel.add(tagLine,g);
		
		//Adding Buttons to buttonPanel
		g.insets = new Insets(100,0,0,0);
		g_for_btns.weightx=1.0;
		g_for_btns.gridx=0;
		g_for_btns.gridy=0;
		
		
		g_for_btns.insets = new Insets(0,0,0,160);
		buttonPanel.add(btn_CreateQuiz,g_for_btns);
		g_for_btns.gridx=1;
		g_for_btns.insets = new Insets(0,0,0,0);
		buttonPanel.add(btn_JoinQuiz,g_for_btns);
		
		//Adding buttonPanel to homePanel
		g.gridx=0;
		g.gridy=2;
		homePanel.add(buttonPanel,g);
		
		//Setting up Action Listeners
		btn_CreateQuiz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Clicked Button : Create Quiz");
			}
			
		});
		
		btn_JoinQuiz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Clicked Button : Join Quiz");
			}
			
		});
	}
	
	public JPanel getHomePanel()
	{
		return homePanel;
	}
	
	// Main method for Testing 
	public static void main(String[]args)
	{
		HomePage p = new HomePage();
		JFrame frame = new JFrame();
		frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(p.getHomePanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
