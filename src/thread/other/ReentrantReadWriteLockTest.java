package thread.other;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {
		MyReadWriteClass myread = new MyReadWriteClass();

		new Thread(new Runnable() {
			@Override
			public void run() {
				myread.read();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				myread.read();
			}
		}).start();
	}

}

class MyReadWriteClass {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void read() {
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName() + "进入中...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "执行结束...");
		lock.readLock().unlock();// 可以在其他线程里面解锁吗？？？
	}
}
