package thread.other;

public class ThreadTest {
	public static void main(String[] args) {

	}

}

class ThreadA extends Thread {
	@Override
	public void run() {
		System.out.println("ThreadA is running");
	}
}

class ThreadB extends Thread {
	@Override
	public void run() {
		System.out.println("ThreadB is running");
	}
}
