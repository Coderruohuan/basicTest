package thread;

public class ThreadSafeClass {

	public static void main(String[] args) {
		MyTest myTest = new MyTest();
		Thread4 thread1 = new Thread4(myTest);
		thread1.setName("a");
		Thread4 thread2 = new Thread4(myTest);
		thread2.setName("b");
		thread1.start();
		thread2.start();

	}

}

class Thread4 extends Thread {
	private MyTest myTest;

	public Thread4(MyTest myTest) {
		this.myTest = myTest;
	}

	@Override
	public void run() {
		myTest.doSomething(this.getName());
	}
}

class MyTest {
	// 静态变量
	private static int staticNum;
	// 成员变量
	private int fieldNum;

	public void doSomething(String name) {
		int localNum = 0;
		if ("a".equals(name)) {
			staticNum = 1;
			localNum = 1;
			fieldNum = 1;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			staticNum = 2;
			localNum = 2;
			fieldNum = 2;
		}
		System.out.println(
				"name:" + name + ",staticNum:" + staticNum + ",localNum:" + localNum + ",fieldNum:" + fieldNum);

	}

}
