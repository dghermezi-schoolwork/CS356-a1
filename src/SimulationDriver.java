import java.util.Random;

public class SimulationDriver {
	
	private static IVoteService iVoteService = new IVoteService();
	private Question question;
	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		
		int amtStudents = rand.nextInt();
		for (int i = 0; i < amtStudents; i++) {
			
		}
		Student student1 = new Student("10");
		Student student2 = new Student("Dghermezi");
		
		SingleChoiceQuestion question = new SingleChoiceQuestion();
		question.setQuestionText("What is 2+2?");
		question.setAnswerText(new String[] {"1", "2", "3", "4", "5"});
		question.setAnswer(3);
		iVoteService.setQuestion(question, 5000);
		Thread t = new Thread(new Wait(iVoteService.getWaitTime()));
		t.start();
		
		student1.setAnswer(new int[] {0, 0, 1, 0, 0});
		student2.setAnswer(new int[] {0, 0, 0, 0, 1});
		iVoteService.enterAnswer(student1.getID(), student1.getAnswer());
		iVoteService.enterAnswer(student2.getID(), student2.getAnswer());
		student1.setAnswer(new int[] {0, 0, 0, 1, 0});
		iVoteService.enterAnswer(student1.getID(), student1.getAnswer());
		
		t.join();
		iVoteService.stats(question);
		
		question = new SingleChoiceQuestion();
		question.setQuestionText("True or False?");
		question.setAnswerText(new String[] {"True", "False"});
		question.setAnswer(0);
		iVoteService.setQuestion(question, 10000);
		t = new Thread (new Wait(iVoteService.getWaitTime()));
		t.start();
		
	}

}
