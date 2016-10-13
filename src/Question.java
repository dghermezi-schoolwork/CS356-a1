
public abstract class Question {

	private String questionText;
	private String[] answers;
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public void setAnswers(String[] answers) {
		this.answers = new String[answers.length];
		for (int i = 0; i < answers.length; i++) {
			this.answers[i] = answers[i];
		}
	}
	
}
