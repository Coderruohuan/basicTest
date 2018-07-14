package thread.other;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) throws InterruptedException {
		LockClass lockClass = new LockClass();

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				lockClass.print();

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				lockClass.print();

			}
		});
		thread.start();
		thread2.start();

	}
}

class LockClass {
	public ReentrantLock lock = new ReentrantLock(false);

	public void print() {
		// System.out.println(Thread.currentThread().getName() + " " +
		// lock.hasQueuedThread(Thread.currentThread()));
		// 查询当前线程是否在等待此锁,这个貌似不对不想试了
		// lock.isHeldByCurrentThread();当前此线程是否保持此锁（现在放在这边没意义）
		lock.lock();
		System.out.println(lock.isFair());// 此锁是否是公平锁
		System.out.println(Thread.currentThread().getName() + "拥有的线程数：" + lock.getHoldCount());// 该线程此时保持此锁的个数
		System.out.println("等待lock释放的线程数：" + lock.getQueueLength());// 此时等待lock锁释放的线程数
		// lock.getWaitQueueLength(condition); 等待锁定该条件的的线程的数量
		// lock.hasWaiters(condition)是否有线程正在等待与此锁定有关的condition条件
		method();

		lock.unlock();
	}

	public void method() {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "拥有的线程数：" + lock.getHoldCount());
		lock.unlock();
	}

}
