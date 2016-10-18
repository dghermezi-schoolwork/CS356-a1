import java.math.BigInteger;
import java.util.Random;

// This class is used to run the simulation
public class SimulationDriver {

	// First we create an engine. This is necessary so that the table of
	// answers remains static.
	private static IVoteService iVoteService = new IVoteService();
	private Question question;

	// To keep track of our random students.
	private static Student[] students = new Student[35];

	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();

		// Fills the array with students with random IDs
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(new BigInteger(130, rand).toString(32));
		}

		//
		// Student student1 = new Student("10");
		// Student student2 = new Student("Dghermezi");
		//
		Question question = new MultipleChoiceQuestion();
		question.setQuestionText("What is 2+2?");
		question.setAnswerText(new String[] { "1", "2", "3", "4", "5" });
		((MultipleChoiceQuestion) question).setAnswer(new int[] { 0, 0, 0, 1, 0 });
		iVoteService.setQuestion(question, 5000);
		// Thread t = new Thread(new Wait(iVoteService.getWaitTime()));
		// t.start();

		int[] tempAnswer = new int[question.getAnswerText().length];
		for (int i = 0; i < students.length; i++) {

			// First fill the answer array with random answers;
			for (int j = 0; j < tempAnswer.length; j++) {
				tempAnswer[j] = rand.nextInt(2);
			}

			// Then submit each student's answers
			students[i].setAnswer(tempAnswer);
			iVoteService.enterAnswer(students[i]);
		}

		// student1.setAnswer(new int[] { 0, 0, 1, 0, 0 });
		// student2.setAnswer(new int[] { 0, 0, 0, 0, 1 });
		// iVoteService.enterAnswer(student1);
		// iVoteService.enterAnswer(student2);
		// student1.setAnswer(new int[] { 0, 0, 0, 1, 0 });
		// iVoteService.enterAnswer(student1);
		//
		// t.join();
		iVoteService.stats(question);
		//
		question = new SingleChoiceQuestion();
		question.setQuestionText("True or False?");
		question.setAnswerText(new String[] { "True", "False" });
		((SingleChoiceQuestion) question).setAnswer(0);
		iVoteService.setQuestion(question, 10000);
		// t = new Thread(new Wait(iVoteService.getWaitTime()));
		// t.start();

		tempAnswer = new int[question.getAnswerText().length];
		for (int i = 0; i < students.length; i++) {
			// First fill the array with 0s
			for (int j = 0; j < tempAnswer.length; j++) {
				tempAnswer[j] = 0;
			}
			// Then choose one to be the student's answer
			tempAnswer[rand.nextInt(tempAnswer.length)] = 1;

			students[i].setAnswer(tempAnswer);
			iVoteService.enterAnswer(students[i]);
		}

		iVoteService.stats(question);

	}

}
