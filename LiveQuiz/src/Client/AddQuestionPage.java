package Client;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AddQuestionPage {

	private int numberOfQuestions;
	private JPanel questionPanel;
	private JButton btn_SubmitButton;
	private SingleQuestionItem[] singleQuestionItem;
	AddQuestionPage(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel,BoxLayout.Y_AXIS));
	}
//////////////////////////////////////////////////
	private void setup()
	{
		 singleQuestionItem = new SingleQuestionItem[numberOfQuestions];
		  
		 for(int i =1;i<=numberOfQuestions;i++)
		 {
			 singleQuestionItem[i-1] = new SingleQuestionItem(i);
			 questionPanel.add(singleQuestionItem[i-1].getSingleQuestionPanel());
		 }
		 
	}
	
	public JScrollPane getPanel()
	{
		setup();
		JScrollPane scrollPane = new JScrollPane(questionPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);;
		return  scrollPane;
	}
	

public static void main(String[]args)
	{
	  AddQuestionPage addQuestionPage = new AddQuestionPage(10);
	  JFrame frame = new JFrame();
	    frame.setBackground(Res.clr_bg_primary);
		frame.setLayout(new BorderLayout());
		frame.setSize(Res.window_width,Res.window_height);
		frame.setResizable(false);
		frame.add(addQuestionPage.getPanel(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
