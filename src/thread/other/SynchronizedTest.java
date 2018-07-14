package thread.other;

public class SynchronizedTest {

	public static void main(String[] args) {
		SynchronizedClass2 syn2 = new SynchronizedClass2();
		SynchronizedClass1 syn1 = new SynchronizedClass1();
		MyThread4 myThread4 = new MyThread4(syn2, syn1);
		myThread4.setName("A");
		myThread4.start();

		MyThread4 myThread5 = new MyThread4(syn2, syn1);
		myThread5.setName("B");
		myThread5.start();
	}

}

class SynchronizedClass1 {
	public synchronized static void print() throws InterruptedException {
		// 锁住了所有的类对象
		System.out.println("静态方法被修饰为synchronized");
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			System.out.println("static " + Thread.currentThread().getName() + "  " + i);
		}
	}

	public synchronized void print2() throws InterruptedException {
		// 锁住了所有的类对象
		System.out.println("静态方法被修饰为synchronized的方法2");
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			System.out.println("static " + Thread.currentThread().getName() + "  " + i);
		}
	}

}

class SynchronizedClass2 {
	public synchronized void print(String str) throws InterruptedException {
		// 锁住的是对象，对于两个线程运行不同对象是会交互运行，对于同一个对象会等待执行
		System.out.println("实例方法被修饰为synchronized");
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			System.out.println(str + "no  static " + Thread.currentThread().getName() + "  " + i);
		}
	}
}

class MyThread4 extends Thread {
	@SuppressWarnings("unused")
	private SynchronizedClass1 syn1;
	private SynchronizedClass2 syn2;
	private SynchronizedClass2 syn3 = new SynchronizedClass2();

	public MyThread4(SynchronizedClass2 syn2, SynchronizedClass1 syn1) {
		this.syn2 = syn2;
		this.syn1 = syn1;
	}

	@Override
	public void run() {
		// try {
		// syn1.print();
		// if ("A".equals(currentThread().getName())) {
		// Thread.sleep(8000);
		// }
		// syn1.print2();// 上面获得类对象锁执行完后释放，然后B线程可以重新抢
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		try {
			syn2.print("相同对象");
			if ("A".equals(currentThread().getName())) {
				Thread.sleep(8000);
			}
			syn3.print("不相同对象");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}