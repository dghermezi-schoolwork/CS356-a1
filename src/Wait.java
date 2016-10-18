// This is not a required class. It is used to simulate time for 
// students to submit their vote.
public class Wait implements Runnable {

	private int waitTime;
	
	public Wait(int waitTime) {
		this.waitTime = waitTime;
	}

	// When started in a new thread, simply waits...
	public void run() {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
