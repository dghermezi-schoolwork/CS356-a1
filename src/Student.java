
public class Student {
	private String id;
	private int[] answer;
	
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
	
	public void setAnswer(int[] answer) {
		this.answer=new int[answer.length];
		for (int i = 0; i < answer.length; i++) {
				this.answer[i] = answer[i];
		}
	}
	
}
