
public class MultipleChoiceQuestion extends Question {

	private int[] answer;

	public int[] getAnswer() {
		return answer;
	}
	
	public void setAnswer(int[] answer) {
		this.answer=new int[answer.length];
		for (int i = 0; i < answer.length; i++) {
				this.answer[i] = answer[i];
		}
	}


}
