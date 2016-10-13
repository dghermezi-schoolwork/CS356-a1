
public class SingleChoiceQuestion extends Question {
	private int answer;
	
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
