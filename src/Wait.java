
public class Wait implements Runnable {

	private int waitTime;
	public Wait(int waitTime) {
		this.waitTime = waitTime;
	}
	public void run() {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
