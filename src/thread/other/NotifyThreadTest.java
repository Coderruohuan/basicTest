package thread.other;

/**
 * 线程通信
 * 
 * @author Administrator
 *
 */
public class NotifyThreadTest {
	public static void main(String[] args) {
		Object object = new Object();
		new MyThread2(object).start();
		MyThread1 thread = new MyThread1(object);
		thread.setName("A");
		thread.start();
		MyThread1 thread1 = new MyThread1(object);
		thread1.setName("B");
		thread1.start();

	}

}

class MyThread1 extends Thread {
	private Object lock;

	public MyThread1(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "要wait了..........");
		synchronized (lock) {
			try {
				// wait释放锁，如果没有线程执行lock的notify，即使lock的对象锁处于空闲状态
				lock.wait();// 要在同步代码块里不然会报IllegalMonitorStateException
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "执行完毕....");
		}

	}
}

class MyThread2 extends Thread {
	private Object lock;

	public MyThread2(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("线程2要执行了......");
			// lock.notify();// 这个只能随机唤醒1条
			lock.notifyAll();
			System.out.println("线程2执行完毕....");
		}

	}
}