import java.util.HashMap;

// This class serves as the engine for the service
public class IVoteService {

	// A hashmap to store student's answer. The key is their ID
	private HashMap<String, int[]> table = new HashMap();
	private Question currentQuestion;

	// This tells the engine how long to wait before closing the poll.
	private int waitTime;

	// This method clears the table and updates the question and waittime.
	public void setQuestion(Question question, int waitTime) {
		table.clear();
		currentQuestion = question;
		this.waitTime = waitTime;
		System.out.println(currentQuestion);
	}

	// This method enters a student's answer into the table.
	public void enterAnswer(Student student) {
		table.put(student.getID(), student.getAnswer());
	}

	// This method checks the student's answer against the correct answer
	// Currently, an unused method, but could be useful.
	public boolean checkAnswer(Student student, Question question) {
		int[] studentAnswer = student.getAnswer();
		int[] correctAnswer = question.getAnswer();

		// Since answers are stored in an array with 0's being an incorrect
		// selection and 1 being a correct selection, if the student selected an
		// incorrect choice or failed to select a correct choice, then the
		// student's answer is incorrect
		for (int i = 0; i < studentAnswer.length; i++) {
			if (studentAnswer[i] != correctAnswer[i]) {
				return false;
			}
		}
		return true;
	}

	// This prints the statistics from the question by iterating though the
	// table
	public void stats(Question question) {
		System.out.println("-------\n Here are the results!");
		int[] results = new int[question.getAnswerText().length];

		// gets each answer array from the table
		// since 0 is unselected and 1 is selected, we can simply add the
		// corresponding choices in order to count.
		for (int[] studentAnswer : table.values()) {
			for (int i = 0; i < question.getAnswerText().length; i++) {
				results[i] += studentAnswer[i];
			}
		}

		// Then we go back and print the results
		for (int i = 0; i < results.length; i++) {
			System.out.println((char) (i + 65) + ": " + results[i]);
		}
	}

	// Returns the waitTime
	public int getWaitTime() {
		return waitTime;
	}

}
