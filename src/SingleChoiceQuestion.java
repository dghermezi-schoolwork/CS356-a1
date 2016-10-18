// This class represents a single choice question
public class SingleChoiceQuestion extends Question {

	// Since there is only one correct answer, we only store an int
	private int answer;

	// However, in order to avoid other complications, we must return an integer
	// array since thats what Question uses. The idea is that the UI would
	// enforce choosing no more than one answer.
	public int[] getAnswer() {
		int[] answer = new int[this.getQuestionText().length()];
		for (int i = 0; i < this.getQuestionText().length(); i++) {
			answer[i] = 0;
		}
		answer[this.answer] = 1;
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
