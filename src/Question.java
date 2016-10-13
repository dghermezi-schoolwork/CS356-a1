
public abstract class Question {

	private String questionText;
	private String[] answerText;
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public String[] getAnswerText() {
		return answerText;
	}
	
	public void setAnswerText(String[] answerText) {
		this.answerText = new String[answerText.length];
		for (int i = 0; i < answerText.length; i++) {
			this.answerText[i] = answerText[i];
		}
	}
	
	public abstract int[] getAnswer();
	
	public String toString() {
		String output = "";
		String[] possibleAnswers = this.getAnswerText();
		output+= this.getQuestionText();
		output+="\n-------";
		for (int i = 0; i < this.getAnswerText().length; i++) {
			output+="\n" + (char)(i+65) + ": " + possibleAnswers[i];
		}
		return output;
	}
}
