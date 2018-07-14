package thread.other;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main 开始执行");
		Thread thread = new Thread(new MyThread());
		thread.start();
		thread.join(2000);
		System.out.println("main 执行完毕");
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyThread 执行完毕");

	}
}
