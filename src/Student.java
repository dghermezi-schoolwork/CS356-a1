// This class represents a student
public class Student {

	// each student has an ID that is used in the table to store their answer.
	private String id;
	private int[] answer;

	// Simple getters and setters.
	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public Student(String id) {
		this.setID(id);
	}

	public int[] getAnswer() {
		return answer;
	}

	// Must perform a deep copy of the array.
	public void setAnswer(int[] answer) {
		this.answer = new int[answer.length];
		for (int i = 0; i < answer.length; i++) {
			this.answer[i] = answer[i];
		}
	}

}
