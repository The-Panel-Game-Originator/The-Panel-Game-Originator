package Client;

public class QuestionAtt {
	String question;
	String corretOption;
	String optionOne;
	String optionTwo;
	String optionThree;
	
	public QuestionAtt(SingleQuestionItem item) {
	
		question = item.getQuestion();
		corretOption = item.getCorretOption();
		optionOne = item.getOption_w1();
		optionTwo = item.getOption_w2();
		optionThree= item.getOption_w3();
		// TODO Auto-generated constructor stub
	}

}
