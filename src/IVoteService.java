import java.util.HashMap;

public class IVoteService {

	private HashMap<String, int[]> table = new HashMap();
	private Question currentQuestion;
	private int waitTime;

	public void setQuestion(Question question, int waitTime) {
		table.clear();
		currentQuestion = question;
		this.waitTime = waitTime;
		System.out.println(currentQuestion);
	}

	public void enterAnswer(String id, int[] answer) {
		table.put(id, answer);
	}

	public boolean checkAnswer(Student student, Question question) {
		int[] studentAnswer = student.getAnswer();
		int[] correctAnswer = question.getAnswer();
		for (int i = 0; i < studentAnswer.length; i++) {
			if (studentAnswer[i] != correctAnswer[i]) {
				return false;
			}
		}
		return true;
	}

	public void stats(Question question) {
		System.out.println("-------\n Here are the results!");
		int[] results = new int[question.getAnswerText().length];
		for (int[] studentAnswer : table.values()) {
			for (int i = 0; i < question.getAnswerText().length; i++) {
				results[i] += studentAnswer[i];
			}
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println((char) (i + 65) + ": " + results[i]);
		}
	}

	public int getWaitTime() {
		return waitTime;
	}

}
