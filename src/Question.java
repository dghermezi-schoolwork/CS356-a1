// This class represents a question.
public abstract class Question {

	// This is the question itself and an array of answer texts.
	// Each index in the answer array is one possible answer.
	private String questionText;
	private String[] answerText;

	// Returns the question text.
	public String getQuestionText() {
		return questionText;
	}

	// Sets the question text.
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	// gets the answer text
	public String[] getAnswerText() {
		return answerText;
	}

	// Creates a deep copy into the answer text array
	public void setAnswerText(String[] answerText) {
		this.answerText = new String[answerText.length];
		for (int i = 0; i < answerText.length; i++) {
			this.answerText[i] = answerText[i];
		}
	}

	// Each subtype must be able to return the answer in the form of an integer
	// array
	public abstract int[] getAnswer();

	// This makes it so we can simply syso a question to display it and the
	// possible answers.
	public String toString() {
		String output = "";
		String[] possibleAnswers = this.getAnswerText();
		output += this.getQuestionText();
		output += "\n-------";
		for (int i = 0; i < this.getAnswerText().length; i++) {
			output += "\n" + (char) (i + 65) + ": " + possibleAnswers[i];
		}
		return output;
	}
	
//	public Question(String questionText, String[] answerText) {
//		this.questionText = questionText;
//		
//		// Create deep copies
//		for (int i = 0; i < answerText.length; i++) {
//			this.answerText[i] = answerText[i];
//		}
//		
//	}
}
