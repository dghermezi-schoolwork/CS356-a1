// This class is a subclass of the type Question
public class MultipleChoiceQuestion extends Question {

	// Since it is multiple choice, it is possible for there to be more than one
	// correct answer. We will represent this by a 1 in the corresponding spot
	// in the array.
	private int[] answer;

	// Simply returns the answer
	public int[] getAnswer() {
		return answer;
	}

	// Makes a deep copy of the inputed answers.
	public void setAnswer(int[] answer) {
		this.answer = new int[answer.length];
		for (int i = 0; i < answer.length; i++) {
			this.answer[i] = answer[i];
		}
	}

}
